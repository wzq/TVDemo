/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.wzq.leanback.app;

import com.wzq.leanback.media.PlaybackGlue;
import com.wzq.leanback.media.PlaybackGlueHost;
import com.wzq.leanback.media.SurfaceHolderGlueHost;
import android.view.SurfaceHolder;

/**
 * {@link PlaybackGlueHost} implementation
 * the interaction between {@link PlaybackGlue} and {@link VideoFragment}.
 */
public class VideoFragmentGlueHost extends PlaybackFragmentGlueHost
        implements SurfaceHolderGlueHost {
    private final VideoFragment mFragment;

    public VideoFragmentGlueHost(VideoFragment fragment) {
        super(fragment);
        this.mFragment = fragment;
    }

    /**
     * Sets the {@link SurfaceHolder.Callback} on the host.
     * {@link PlaybackGlueHost} is assumed to either host the {@link SurfaceHolder} or
     * have a reference to the component hosting it for rendering the video.
     */
    @Override
    public void setSurfaceHolderCallback(SurfaceHolder.Callback callback) {
        mFragment.setSurfaceHolderCallback(callback);
    }
}
