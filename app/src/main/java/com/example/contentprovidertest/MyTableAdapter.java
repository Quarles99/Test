package com.example.contentprovidertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyTableAdapter extends BaseAdapter {
    private List<FunkoPopData> data;
    private LayoutInflater inflater;

    public MyTableAdapter(Context context, List<FunkoPopData> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.table_row, null);
        }

        TextView textViewID = convertView.findViewById(R.id.textViewID);
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewNumber = convertView.findViewById(R.id.textViewNumber);
        TextView textViewType = convertView.findViewById(R.id.textViewType);
        TextView textViewFandom = convertView.findViewById(R.id.textViewFandom);
        TextView textViewOn = convertView.findViewById(R.id.textViewOn);
        TextView textViewUltimate = convertView.findViewById(R.id.textViewUltimate);
        TextView textViewPrice = convertView.findViewById(R.id.textViewPrice);

        FunkoPopData item = data.get(position);
        textViewName.setText(item.getName());
        textViewNumber.setText(String.valueOf(item.getNumber()));
        textViewID.setText(String.valueOf(item.getId()));
        textViewType.setText(item.getPopType());
        textViewFandom.setText(item.getFandom());
        textViewOn.setText(String.valueOf(item.isOn()));
        textViewUltimate.setText(item.getUltimate());
        textViewPrice.setText(String.valueOf(item.getPrice()));


        // Set data for other columns

        return convertView;
    }
}