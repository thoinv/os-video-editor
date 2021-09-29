package com.example.videoeditor.entities;

import androidx.annotation.DrawableRes;

import com.example.videoeditor.R;

public class TextStyleItem {
    TextStyleItem(String name, int coverRes) {
        this.name = name;
        this.coverRes = coverRes;
    }

    public static TextStyleItem createNone() {
        return new TextStyleItem("none", R.drawable.all_ic_none);
    }

    public static TextStyleItem create(String name, @DrawableRes int coverRes) {
        return new TextStyleItem(name, coverRes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoverRes() {
        return coverRes;
    }

    public void setCoverRes(int coverRes) {
        this.coverRes = coverRes;
    }

    private String name;
    private int coverRes;
}
