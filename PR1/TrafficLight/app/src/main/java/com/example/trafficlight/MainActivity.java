package com.example.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;
    private TextView mInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        mInfoTextView = (TextView) findViewById(R.id.textView);

        Button yellowButton = (Button) findViewById(R.id.buttonYellow);
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInfoTextView.setText(R.string.RU_yellow);
                mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.yellow, null));
            }
        });
    }

    public void onRedButtonClick(View view) {
        mInfoTextView.setText(R.string.RU_red);
        mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.red, null));
    }

    public void onGreenButtonClick(View view) {
        mInfoTextView.setText(R.string.RU_green);
        mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.green, null));
    }
}