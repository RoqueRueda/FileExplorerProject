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
package com.roque.rueda.fileexplorer.model;

import java.io.File;
import java.util.Date;

/**
 * Represents a item for the FileList
 *
 * Created by Roque on 4/11/13.
 */
public class FileItem {

    /**
     * Path of the file.
     */
    private File mPath;

    /**
     * Name of the file.
     */
    private String mName;

    /**
     * Size of the file.
     */
    private long mSize;

    /**
     * Last modified date of the file.
     */
    private Date mLastModified;

    /**
     * Creates an item base on the file path
     * @param filePath path of the file.
     */
    public FileItem(String filePath) {
        mPath = new File(filePath);
        mName = mPath.getName();
        mSize = 0;
    }

    /**
     * Default constructor.
     */
    public FileItem () {
        // Nothing here
    }

    /**
     *
     * @param path path to the file.
     */
    public void setPath(File path) {
        mPath = path;
    }

    /**
     *
     * @param name name of the file.
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     *
     * @param size size of the file.
     */
    public void setSize(long size) {
        mSize = size;
    }

    /**
     *
     * @param lastModified set last modified date.
     */
    public void setLastModified(Date lastModified) {
        mLastModified = lastModified;
    }

    /**
     *
     * @return path of the current file.
     */
    public File getPath() {
        return mPath;
    }

    /**
     *
     * @return name of the current file.
     */
    public String getName() {
        return mName;
    }

    /**
     *
     * @return size of the current file
     */
    public long getSize() {
        return mSize;
    }

    /**
     *
     * @return date whether this date was modified
     */
    public Date getLastModified() {
        return mLastModified;
    }

    /**
     * @returnn integer hash code for this object.
     */
    @Override
    public int hashCode() {
        final int baseValue = 101;
        int result = 1;
        result = baseValue * result + ((mPath == null) ? 0: mPath.hashCode());
        return result;
    }

    /**
     * Compares this instance with the specified object and indicates
     * if they are equal. In order to be equal, o must represent the
     * same object as this instance using a class-specific comparison.
     * The general contract is that this comparison should be reflexive,
     * symmetric, and transitive. Also, no object reference other than
     * null is equal to null.
     *
     * @param o Object that is going to be compare with this object
     * @return true if the object is same as other object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileItem)) return false;

        FileItem fileItem = (FileItem) o;

        if (mPath != null ?
                !mPath.equals(fileItem.mPath) : fileItem.mPath != null)
            return false;

        return true;
    }
}
