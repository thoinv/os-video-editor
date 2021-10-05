package com.example.videoeditor.entities;

import androidx.annotation.DrawableRes;

public class FilterItem {
    private final int id;
    private final String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCover() {
        return cover;
    }

    private final int cover;

    FilterItem(int id, String name, int cover) {
        this.id = id;
        this.name = name;
        this.cover = cover;
    }

    public static FilterItem createItem(int id, String name, @DrawableRes int cover) {
        return new FilterItem(id, name, cover);
    }

}
