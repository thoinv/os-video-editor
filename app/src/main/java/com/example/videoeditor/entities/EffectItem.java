package com.example.videoeditor.entities;

import androidx.annotation.DrawableRes;

public class EffectItem {
    private final int id;
    private final String name;
    private final int cover;

    public static EffectItem createItem(int id, String name, @DrawableRes int cover) {
        return new EffectItem(id, name, cover);
    }

    EffectItem(int id, String name, int cover) {
        this.id = id;
        this.name = name;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCover() {
        return cover;
    }
}
