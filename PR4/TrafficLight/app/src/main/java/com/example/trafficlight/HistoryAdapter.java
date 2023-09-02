package com.example.trafficlight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Integer mItemLayout;
    private ArrayList<HistoryItem> mHistory;
    HistoryAdapter(Context context, Integer itemLayout, ArrayList<HistoryItem> history) {
        super();
        mItemLayout = itemLayout;
        mHistory = history;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mHistory.size();
    }

    @Override
    public HistoryItem getItem(int i) {
        return mHistory.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(mItemLayout, parent, false);

        TextView textView = view.findViewById(R.id.historyItem);

        HistoryItem historyItem = getItem(position);

        textView.setText(view.getResources().getString(historyItem.getText()));
        textView.setBackgroundColor(view.getResources().getColor(historyItem.getColor(), null));

        return view;
    }
}
