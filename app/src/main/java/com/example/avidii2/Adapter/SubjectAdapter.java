package com.example.avidii2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avidii2.Model.Subject;
import com.example.avidii2.R;

import java.util.ArrayList;

public class SubjectAdapter extends ArrayAdapter<Subject> {
    public SubjectAdapter(Context context, ArrayList<Subject> subjects) {
        super(context, 0, subjects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Subject subject = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // Lookup view for data population
        ImageView icon = (ImageView) convertView.findViewById(R.id.imageView);
        TextView name = (TextView) convertView.findViewById(R.id.textView);

        // Populate the data into the template view using the data object
        icon.setImageResource(subject.getIcon());
        name.setText(subject.getName());

        // Return the completed view to render on screen
        return convertView;
    }
}
