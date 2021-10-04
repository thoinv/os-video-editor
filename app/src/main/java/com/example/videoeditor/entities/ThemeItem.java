package com.example.videoeditor.entities;

import androidx.annotation.DrawableRes;

import com.example.videoeditor.R;

public class ThemeItem {
    private final int id;
    private final String name;
    private final int cover;

    ThemeItem(int id, String name, int cover) {
        this.id = id;
        this.name = name;
        this.cover = cover;
    }

    public static ThemeItem createNone() {
        return new ThemeItem(0, "None", R.drawable.all_ic_none);
    }

    public static ThemeItem createItem(int id, String name, @DrawableRes int cover) {
        return new ThemeItem(id, name, cover);
    }

    public int getCover() {
        return cover;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
