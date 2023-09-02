package com.example.trafficlight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    HistoryAdapter mHistoryAdapter;
    ArrayList<HistoryItem> mHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra(getString(R.string.HISTORY_KEY))) {
            mHistory = intent.getParcelableArrayListExtra(getString(R.string.HISTORY_KEY));
        }

        mHistoryAdapter = new HistoryAdapter(this, R.layout.item_activity_history, mHistory);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(mHistoryAdapter);
    }
}