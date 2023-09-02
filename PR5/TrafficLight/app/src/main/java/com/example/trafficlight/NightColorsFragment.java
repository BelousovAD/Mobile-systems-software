package com.example.trafficlight;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NightColorsFragment extends Fragment {

    private MainActivity activity;

    public NightColorsFragment() {
        // Required empty public constructor
    }

    public static NightColorsFragment newInstance() {
        return new NightColorsFragment();
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
        View view = inflater.inflate(R.layout.fragment_night_colors, container, false);

        Button buttonDarkBlue = view.findViewById(R.id.buttonDarkBlue);
        Button buttonDarkGrey = view.findViewById(R.id.buttonDarkGrey);
        Button buttonDarkPurple = view.findViewById(R.id.buttonDarkPurple);

        buttonDarkBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ((Branch) activity).onClickFragmentButton(R.string.dark_blue, R.color.dark_blue);
                } catch (ClassCastException ignored) {}
            }
        });
        buttonDarkGrey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ((Branch) activity).onClickFragmentButton(R.string.dark_grey, R.color.dark_grey);
                } catch (ClassCastException ignored) {}
            }
        });
        buttonDarkPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ((Branch) activity).onClickFragmentButton(R.string.dark_purple, R.color.dark_purple);
                } catch (ClassCastException ignored) {}
            }
        });

        return view;
    }
}