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

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.appcompat.R;
import android.webkit.MimeTypeMap;

import java.io.File;
import java.io.IOException;

/**
 * Contains a set of common methods that are used to get the proper
 * icon to show display an icon to the user.
 *
 * Created by Roque on 16/11/13.
 */
public class IconUtil {

    private static final String TAG = "IconUtil";

    private static final String AUDIO_FILE = "audio/";
    private static final String VIDEO_FILE = "video/";
    private static final String IMAGE_FILE = "image/";
    private static final String ZIP_FILE = ".zip";
    private static final String ROOT = "/";

    /**
     * Gets the mime type for the specified type.
     * @param file File that is going to be analyzed.
     * @return String mime type name of the file.
     */
    private static String getMimeType(File file) {
        // Creates a Uri for the file.
        Uri uri = Uri.fromFile(file);
        // Gets the mime type string from his uri
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()));
    }


    /**
     * Determines if a file is a Audio File using his mime type.
     * @param file File that is going to be analyzed
     * @return true if the file is consider as a Audio type.
     */
    static boolean isMusic(File file) {
        String type = getMimeType(file);

        if(type == null) {
            return false;
        } else {
            return type.toLowerCase().startsWith(AUDIO_FILE);
        }
    }

    /**
     * Determines if a file is a Video File using his mime type.
     * @param file File that is going to be analyzed
     * @return true if the file is consider as a Audio type.
     */
    static boolean isVideo(File file) {
        String type = getMimeType(file);

        if(type == null) {
            return false;
        } else {
            return type.toLowerCase().startsWith(VIDEO_FILE);
        }
    }

    /**
     * Determines if a file is a Image File using his mime type.
     * @param file File that is going to be analyzed
     * @return true if the file is consider as a Audio type.
     */
    static boolean isPicture(File file) {
        String type = getMimeType(file);

        if(type == null) {
            return false;
        } else {
            return type.toLowerCase().startsWith(IMAGE_FILE);
        }
    }

    /**
     * Determines if a path of the file system is protected.
     * @param path Path that is going to be analyzed.
     * @return true if the path can not be read or write in.
     */
    public static boolean isProtected(File path) {
        return (!path.canRead() && !path.canWrite());
    }

    /**
     * Indicate if the path is a zip file.
     * @param path Path that is going to be analyzed.
     * @return true of the file is a zip file.
     */
    public static boolean isUnzippable(File path) {
        return (path.isFile() && path.canRead() && path.getName().endsWith(ZIP_FILE));
    }

    /**
     * Determines if the dir is the root path or not.
     * @param dir directory that is going to be analyzed.
     * @return true if the directory is the root path.
     */
    public static boolean isRootFile(File dir) {
        return dir.getAbsolutePath().equals(ROOT);
    }

    /**
     * Determines if the directory is the sd card or not.
     * @param file file that is going to be analyzed.
     * @return true if the directory is the sd card.
     */
    public static boolean isSdCard(File file) {
        try {
            return (file.getCanonicalPath().equals(Environment.getExternalStorageDirectory().getCanonicalPath()));
        } catch (IOException ioe){
            return false;
        }
    }

    public static Drawable getIcon(Context ctx, File file) {

        // Is this a directory?
        if (!file.isFile()) {
            if (isProtected(file)) {
                return ctx.getResources().getDrawable(R.drawable.ic_sys);
            } else if (isSdCard(file)) {
                return ctx.getResources().getDrawable(R.drawable.ic_sd);
            } else {
                return ctx.getResources().getDrawable(R.drawable.ic_folder);
            }
        } else {
            String fileName = file.getName();
            if (isProtected(file)) {
                return ctx.getResources().getDrawable(R.drawable.ic_sys);
            } else if (fileName.endsWith(".apk")) {
                return ctx.getResources().getDrawable(R.drawable.ic_apk);
            } else if (fileName.endsWith(".zip")) {
                return ctx.getResources().getDrawable(R.drawable.ic_zip);
            } else if (isMusic(file)) {
                return ctx.getResources().getDrawable(R.drawable.ic_audio_file);
            } else if (isVideo(file)) {
                return ctx.getResources().getDrawable(R.drawable.ic_video_file);
            } else if (isPicture(file)) {
                return ctx.getResources().getDrawable(R.drawable.ic_image);
            } else {
                return ctx.getResources().getDrawable(R.drawable.ic_file);
            }
        }
    }

}
