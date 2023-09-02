package com.example.trafficlight;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class HistoryItem implements Parcelable {
    private final Integer mText;
    private final Integer mColor;

    public static final Creator<HistoryItem> CREATOR = new Creator<HistoryItem>() {
        @Override
        public HistoryItem createFromParcel(Parcel in) {
            return new HistoryItem(in);
        }

        @Override
        public HistoryItem[] newArray(int size) {
            return new HistoryItem[size];
        }
    };

    public HistoryItem(Integer text, Integer color) {
        mText = text;
        mColor = color;
    }

    public HistoryItem(Parcel in) {
        mText = in.readInt();
        mColor = in.readInt();
    }

    public Integer getText() {
        return mText;
    }

    public Integer getColor() {
        return mColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(mText);
        parcel.writeInt(mColor);
    }
}
