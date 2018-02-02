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

import android.content.Context;
import android.view.ContextThemeWrapper;

import com.bumptech.glide.Glide;
import com.wzq.leanback.widget.ImageCardView;
import com.wzq.leanback.widget.Presenter;


/**
 * A very basic {@link ImageCardView} {@link Presenter}.You can
 * pass a custom style for the ImageCardView in the constructor. Use the default constructor to
 * create a Presenter with a default ImageCardView style.
 */
public class ImageCardViewPresenter extends AbstractCardPresenter<ImageCardView> {

    public ImageCardViewPresenter(Context context, int cardThemeResId) {
        super(new ContextThemeWrapper(context, cardThemeResId));
    }

    public ImageCardViewPresenter(Context context) {
        this(context, R.style.DefaultCardTheme);
    }

    @Override
    protected ImageCardView onCreateView() {
        ImageCardView imageCardView = new ImageCardView(getContext());
//        imageCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "Clicked on ImageCardView", Toast.LENGTH_SHORT).show();
//            }
//        });
        return imageCardView;
    }

    @Override
    public void onBindViewHolder(Object card, final ImageCardView cardView) {
        cardView.setTag(card);
        cardView.setTitleText("title");
//        cardView.setContentText(card.getDescription());
//        if (card.getLocalImageResourceName() != null) {
//            int resourceId = getContext().getResources()
//                    .getIdentifier(card.getLocalImageResourceName(),
//                            "drawable", getContext().getPackageName());
            Glide.with(getContext())
                    .load(R.drawable.card_image_movie_01)
                    .into(cardView.getMainImageView());
//        }
    }

}