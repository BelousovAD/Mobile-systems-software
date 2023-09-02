package com.example.trafficlight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Branch {

    private LinearLayout mMainLayout;
    private TextView mInfoTextView;
    private ArrayList<HistoryItem> mHistory;
    private int state;
    private final int TRAFFIC_STATE = 1;
    private final int NIGHT_STATE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHistory = new ArrayList<>();
        mMainLayout = findViewById(R.id.mainLayout);
        mInfoTextView = findViewById(R.id.textView);
        FrameLayout mFragmentSlot = findViewById(R.id.fragmentSlot);

        Button switchButton = findViewById(R.id.buttonSwitch);
        if (mFragmentSlot != null) {
            setTrafficLightFragment();
            switchButton.setOnClickListener(view -> switchFragment());
        }
    }

    @Override
    public void onClickFragmentButton(Integer text, Integer color) {
        mInfoTextView.setText(getResources().getString(text));
        mMainLayout.setBackgroundColor(getResources().getColor(color, null));
        mHistory.add(new HistoryItem(text, color));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(getString(R.string.TEXT_KEY), mInfoTextView.getText());
        outState.putInt(getString(R.string.COLOR_KEY), ((ColorDrawable)mMainLayout.getBackground()).getColor());
        outState.putParcelableArrayList(getString(R.string.HISTORY_KEY), mHistory);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mInfoTextView.setText(savedInstanceState.getCharSequence(getString(R.string.TEXT_KEY)));
        mMainLayout.setBackgroundColor(savedInstanceState.getInt(getString(R.string.COLOR_KEY)));
        mHistory = savedInstanceState.getParcelableArrayList(getString(R.string.HISTORY_KEY));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.openHistoryItem:
                Intent intent = new Intent(this, HistoryActivity.class);
                intent.putParcelableArrayListExtra(getString(R.string.HISTORY_KEY), mHistory);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentSlot, fragment);
        fragmentTransaction.commit();
    }

    private void setTrafficLightFragment(){
        setFragment(TrafficLightFragment.newInstance());
        state = TRAFFIC_STATE;
    }
    private void setNightColorsFragment(){
        setFragment(NightColorsFragment.newInstance());
        state = NIGHT_STATE;
    }

    private void switchFragment(){
        if(state == TRAFFIC_STATE){
            setNightColorsFragment();
        } else if (state == NIGHT_STATE) {
            setTrafficLightFragment();
        }
    }
}