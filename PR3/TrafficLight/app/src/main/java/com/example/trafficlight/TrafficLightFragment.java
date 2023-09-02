package com.example.trafficlight;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TrafficLightFragment extends Fragment {

    private MainActivity activity;

    public TrafficLightFragment() {
        // Required empty public constructor
    }

    public static TrafficLightFragment newInstance() {
        return new TrafficLightFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            activity = (MainActivity) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_traffic_light, container, false);

        Button redButton = view.findViewById(R.id.buttonRed);
        Button yellowButton = view.findViewById(R.id.buttonYellow);
        Button greenButton = view.findViewById(R.id.buttonGreen);

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ((Branch) activity).fragmentMail(R.string.red, R.color.red);
                } catch (ClassCastException ignored) {}
            }
        });
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ((Branch) activity).fragmentMail(R.string.yellow, R.color.yellow);
                } catch (ClassCastException ignored) {}
            }
        });
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ((Branch) activity).fragmentMail(R.string.green, R.color.green);
                } catch (ClassCastException ignored) {}
            }
        });

        return view;
    }
}