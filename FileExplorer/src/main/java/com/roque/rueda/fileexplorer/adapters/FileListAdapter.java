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
package com.roque.rueda.fileexplorer.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.roque.rueda.fileexplorer.ExplorerActivity;
import com.roque.rueda.fileexplorer.model.FileItem;
import com.roque.rueda.fileexplorer.R;

import java.util.List;

/**
 * Adapter that used to show the file items in a list view.
 *
 * Created by Roque on 13/11/13.
 */
public class FileListAdapter extends BaseAdapter {

    /**
     * This class represents a container for each view.
     */
    public static class ViewHolder {
        public TextView resName;
        public ImageView resIcon;
        public ImageView resActions;
        public TextView resMeta;
    }

    private static final String TAG = "FileListAdapter";
    private ExplorerActivity mContext;
    private List<FileItem> mFiles;
    private LayoutInflater mInflater;

    /**
     * Creates an instance and set the required values for this adapter.
     * @param context Context for this File List adapter.
     * @param files List of files to show as items on the list.
     */
    public FileListAdapter(ExplorerActivity context, List<FileItem> files) {
        super();

        mContext = context;
        this.mFiles = files;
        mInflater = context.getLayoutInflater();
    }

    /**
     *
     * @return Number of items that are on the list.
     */
    @Override
    public int getCount() {
        if (mFiles == null) {
            return 0;
        } else {
            return mFiles.size();
        }
    }

    /**
     * Get the object at the specified position.
     *
     * @param position index that is used to retrieve data from the list.
     * @return Object at the specified position or null if the list of
     * items is null.
     */
    @Override
    public Object getItem(int position) {
        if (mFiles == null) {
            return null;
        } else {
            return  mFiles.get(position);
        }
    }

    /**
     *
     * @param position Index that is used to get the id.
     * @return Id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return  position;
    }

    /**
     * Get the a View to present data in the specified position.
     * @param position Index that is used to get a View.
     * @param convertView The old view to reuse, if possible.
     * @param parent The parent that this view will eventually be attached to.
     * @return View that displays the data at the specified position in the data set.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        // Check if the convertView is null
        if (convertView == null) {
            // Inflate the convert View.
            convertView = mInflater.inflate(R.layout.explorer_item, parent, false);

            holder = new ViewHolder();
            holder.resName = (TextView) convertView.findViewById(R.id.explorer_resName);
            holder.resMeta = (TextView) convertView.findViewById(R.id.explorer_resIcon);
            holder.resIcon = (ImageView) convertView.findViewById(R.id.explorer_resIcon);
            holder.resActions = (ImageView) convertView.findViewById(R.id.explorer_resActions);

            // Set the holder into the view as data.
            convertView.setTag(holder);
        } else {

            // Get the data from the view.
            holder = (ViewHolder) convertView.getTag();
        }

        final FileItem currentFile = mFiles.get(position);
        holder.resName.setText(currentFile.getName());
        holder.resIcon.setImageDrawable(Util.getIcon);


    }
}
