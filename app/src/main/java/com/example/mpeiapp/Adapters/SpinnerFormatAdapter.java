package com.example.mpeiapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mpeiapp.R;

import java.util.List;

public class SpinnerFormatAdapter extends ArrayAdapter<String> {

    String[] list;

    public SpinnerFormatAdapter(@NonNull Context context, int textViewResourceId, @NonNull String[] objects) {
        super(context, textViewResourceId, objects);

        this.list = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.spinner_format_item, parent,false);
        TextView label = item.findViewById(R.id.text_format);

        label.setText(list[position]);

        return item;
    }
}
