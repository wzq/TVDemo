/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wzq.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wzq.leanback.app.BrowseFragment;
import com.wzq.leanback.widget.ArrayObjectAdapter;
import com.wzq.leanback.widget.DividerRow;
import com.wzq.leanback.widget.HeaderItem;
import com.wzq.leanback.widget.ImageCardView;
import com.wzq.leanback.widget.OnItemViewClickedListener;
import com.wzq.leanback.widget.Presenter;
import com.wzq.leanback.widget.PresenterSelector;
import com.wzq.leanback.widget.Row;
import com.wzq.leanback.widget.RowPresenter;
import com.wzq.leanback.widget.SectionRow;

import java.util.ArrayList;
import java.util.List;

/**
 * This fragment will be shown when the "Card Examples" card is selected at the home menu. It will
 * display multiple card types.
 */
public class CardExampleFragment extends BrowseFragment {

    private ArrayObjectAdapter mRowsAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupUi();
        setupRowAdapter();
    }

    private void setupUi() {
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setTitle(getString(R.string.card_examples_title));
        setOnSearchClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), getString(R.string.implement_search),
                        Toast.LENGTH_LONG).show();
            }
        });
        setOnItemViewClickedListener(new OnItemViewClickedListener() {

            @Override
            public void onItemClicked(Presenter.ViewHolder viewHolder, Object item, RowPresenter.ViewHolder viewHolder1, Row row) {
//                    Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity()).toBundle();
//                    Intent intent =  new Intent().setClass(getActivity().getBaseContext(), GridExampleActivity.class);
//                    startActivity(intent, bundle);
                }


        });

        prepareEntranceTransition();
    }

    private void setupRowAdapter() {
        mRowsAdapter = new ArrayObjectAdapter(new ShadowRowPresenterSelector());
        setAdapter(mRowsAdapter);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                createRows();
                startEntranceTransition();
            }
        }, 500);
    }

    private void createRows() {
//        String json = Utils
//                .inputStreamToString(getResources().openRawResource(R.raw.cards_example));
//        CardRow[] rows = new Gson().fromJson(json, CardRow[].class);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i+"item");
        }
        for (String row : list) {
            //System.out.println(row.getTitle()+"-"+row.getType());
            mRowsAdapter.add(createCardRow(list));
        }
    }

    private Row createCardRow(final List<String> cardRow) {
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new ImageCardViewPresenter(getActivity()));
        for (String card : cardRow) {
            listRowAdapter.add(card);
        }
        return new CardListRow(new HeaderItem("asdsd"), listRowAdapter, cardRow);
    }

}
