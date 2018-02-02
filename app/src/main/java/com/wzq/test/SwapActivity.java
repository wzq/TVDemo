package com.wzq.test;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzq on 2018/2/2.
 */

public class SwapActivity extends Activity {

    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);
        ViewGroup selections = findViewById(R.id.selection);
        for (int i = 0; i < selections.getChildCount(); i++) {
            View v = selections.getChildAt(i);
            v.setTag(i);
            v.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if (b){
                        next((Integer) view.getTag());
                    }
                }
            });
        }

        fragments.add(SwapFragment.newInstance(R.color.fastlane_background));
        fragments.add(SwapFragment.newInstance(R.color.search_color));
        fragments.add(SwapFragment.newInstance(R.color.loading_error_card_background));

    }


    private void next(int i){
         getFragmentManager().beginTransaction()
                 .setCustomAnimations(R.animator.swap_in, R.animator.swap_out)
                 .replace(R.id.container, fragments.get(i)).commit();
    }
}
