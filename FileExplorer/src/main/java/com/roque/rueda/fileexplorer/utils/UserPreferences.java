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
package com.roque.rueda.fileexplorer.utils;

import android.app.Activity;
import android.preference.PreferenceManager;

import java.io.File;

/**
 * Created by Roque on 27/10/13.
 *
 * User preferences for this application.
 *
 */
public class UserPreferences {

    /**
     * Default directory, this is used to display the first
     * directory to the end user.
     */
    public static final String DEFAULT_HOME_DIR = "homeDir";

    /**
     * Default sd card options.
     */
    public static final String PREF_SD_CARD_OPTIONS = "sdCardOptions";

    /**
     * This is used to show system files.
     */
    public static final String PREF_SHOW_SYSTEM_FILES = "showSysFiles";

    /**
     * Initial directory.
     */
    private static final String INITIAL_DIR = "/";

    /**
     * Context of the application.
     */
    private Activity mContext;

    /**
     * Builds a new user preferences using an activity as
     * context.
     * @param context Context that is going to be used in
     *                this user preferences.
     */
    public UserPreferences(Activity context) {
        mContext = context;
    }

    /**
     * Gets the start directory if not exists it's created.
     * @return File reference to the start directory.
     */
    public File getStartDir() {
        // Gets the default start path
        String dirPath = PreferenceManager
                .getDefaultSharedPreferences(mContext).getString(DEFAULT_HOME_DIR,
                        INITIAL_DIR);

        File homeDir = new File(dirPath);

        if (homeDir.exists() && homeDir.isDirectory()) {
            return homeDir;
        } else {
            return new File(INITIAL_DIR);
        }

    }

    /**
     * Indicates whether this application is showing system files or not
     * @return true if the system files are showing
     */
    public boolean isShowSystemFiles() {
        return PreferenceManager.getDefaultSharedPreferences(mContext)
                .getBoolean(PREF_SHOW_SYSTEM_FILES, true);
    }

    /**
     * Indicates whether this application have sd card options enable.
     * @return true if the user have sd card options.
     */
    public boolean isEnableSdCardOptions() {
        return  PreferenceManager.getDefaultSharedPreferences(mContext)
                .getBoolean(PREF_SD_CARD_OPTIONS, true);
    }

}
