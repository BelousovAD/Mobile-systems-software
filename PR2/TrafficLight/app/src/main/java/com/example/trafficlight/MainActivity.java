package com.example.trafficlight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mMainLayout;
    private TextView mInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainLayout = findViewById(R.id.mainLayout);
        mInfoTextView = findViewById(R.id.textView);

        Button redButton = findViewById(R.id.buttonRed);
        Button yellowButton = findViewById(R.id.buttonYellow);
        Button greenButton = findViewById(R.id.buttonGreen);

        redButton.setOnClickListener(view -> {
            mInfoTextView.setText(R.string.red);
            mMainLayout.setBackgroundColor(getResources().getColor(R.color.red, null));
        });
        yellowButton.setOnClickListener(view -> {
            mInfoTextView.setText(R.string.yellow);
            mMainLayout.setBackgroundColor(getResources().getColor(R.color.yellow, null));
        });
        greenButton.setOnClickListener(view -> {
            mInfoTextView.setText(R.string.green);
            mMainLayout.setBackgroundColor(getResources().getColor(R.color.green, null));
        });
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
}