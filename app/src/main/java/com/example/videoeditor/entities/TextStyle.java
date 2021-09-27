package com.example.videoeditor.entities;

import androidx.annotation.DrawableRes;

import com.example.videoeditor.R;

public class TextStyle {
    TextStyle(String name, int coverRes) {
        this.name = name;
        this.coverRes = coverRes;
    }

    public static TextStyle createNone() {
        return new TextStyle("none", R.drawable.all_ic_none);
    }

    public static TextStyle create(String name, @DrawableRes int coverRes) {
        return new TextStyle(name, coverRes);
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
