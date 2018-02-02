/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wzq.leanback.widget;

import com.wzq.leanback.R;
import com.wzq.leanback.app.DetailsFragment;
import com.wzq.leanback.app.DetailsFragmentBackgroundController;
import com.wzq.leanback.app.DetailsSupportFragment;
import com.wzq.leanback.app.DetailsSupportFragmentBackgroundController;

/**
 * Subclass of Parallax object that tracks overview row's top and bottom edge in DetailsFragment
 * or DetailsSupportFragment.
 * <p>
 * It can be used for both creating cover image parallax effect and controlling video playing
 * when transitioning to/from half/full screen.  A direct use case is
 * {@link DetailsFragmentBackgroundController}.
 * </p>
 * @see DetailsFragment#getParallax()
 * @see DetailsFragmentBackgroundController
 * @see DetailsSupportFragment#getParallax()
 * @see DetailsSupportFragmentBackgroundController
 */
public class DetailsParallax extends RecyclerViewParallax {
    final Parallax.IntProperty mFrameTop;
    final Parallax.IntProperty mFrameBottom;

    public DetailsParallax() {
        // track the top edge of details_frame of first item of adapter
        mFrameTop = this
                .addProperty("overviewRowTop")
                .adapterPosition(0)
                .viewId(R.id.details_frame);

        // track the bottom edge of details_frame of first item of adapter
        mFrameBottom = this
                .addProperty("overviewRowBottom")
                .adapterPosition(0)
                .viewId(R.id.details_frame)
                .fraction(1.0f);

    }

    /**
     * Returns the top of the details overview row. This is tracked for implementing the
     * parallax effect.
     */
    public Parallax.IntProperty getOverviewRowTop() {
        return mFrameTop;
    }

    /**
     * Returns the bottom of the details overview row. This is tracked for implementing the
     * parallax effect.
     */
    public Parallax.IntProperty getOverviewRowBottom() {
        return mFrameBottom;
    }
}
