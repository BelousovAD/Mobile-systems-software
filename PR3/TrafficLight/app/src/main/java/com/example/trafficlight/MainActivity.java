package com.example.trafficlight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Branch {

    private LinearLayout mMainLayout;
    private TextView mInfoTextView;
    private FrameLayout mFragmentSlot;
    private int state;
    private final int TRAFFIC_STATE = 1;
    private final int NIGHT_STATE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainLayout = findViewById(R.id.mainLayout);
        mInfoTextView = findViewById(R.id.textView);
        mFragmentSlot = findViewById(R.id.fragmentSlot);

        Button switchButton = findViewById(R.id.buttonSwitch);
        if (mFragmentSlot != null) {
            setTrafficLightFragment();
            switchButton.setOnClickListener(view -> switchFragment());
        }
    }

    @Override
    public void fragmentMail(Integer text, Integer color) {
        mInfoTextView.setText(getResources().getString(text));
        mMainLayout.setBackgroundColor(getResources().getColor(color, null));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("text", mInfoTextView.getText());
        outState.putInt("color", ((ColorDrawable)mMainLayout.getBackground()).getColor());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mInfoTextView.setText(savedInstanceState.getCharSequence("text"));
        mMainLayout.setBackgroundColor(savedInstanceState.getInt("color"));
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