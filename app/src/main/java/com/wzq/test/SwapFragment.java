package com.wzq.test;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wzq on 2018/2/2.
 */

public class SwapFragment extends Fragment {

    public static SwapFragment newInstance(@ColorRes int color) {
        
        Bundle args = new Bundle();
        args.putInt("color", color);
        SwapFragment fragment = new SwapFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int color = getArguments().getInt("color", 0);

        View root = inflater.inflate(R.layout.fragment_swap, container, false);
        root.setBackgroundColor(ContextCompat.getColor(getActivity(), color));

        return root;
    }
}
