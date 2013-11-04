/*
 * Copyright 2013 Roque Rueda.
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
package com.roque.rueda.fileexplorer;

import android.app.ListActivity;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;

import com.roque.rueda.fileexplorer.utils.UserPreferences;

/**
 * This is a base class for the file list activities
 * Created by Roque on 4/11/13.
 */
public class AbstractListFileActivity extends ListActivity {

    protected UserPreferences preferences;

    private OnSharedPreferenceChangeListener listener;

    /**
     * Called when the activity is starting. Contains initialization
     * for this activity.
     *
     * @param savedInstanceState values saved in the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        preferences = new UserPreferences(this);

        super.onCreate(savedInstanceState);
    }

    public synchronized UserPreferences getPreferences() { return preferences; }

    /**
     * Perform any final cleanup before an activity is destroyed.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
