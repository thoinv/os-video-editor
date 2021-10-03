package com.example.videoeditor.entities;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

public class StickerItem implements Serializable {
    private final int id;
    private final int cover;

    public static StickerItem createItem(int id, @DrawableRes int cover) {
        return new StickerItem(id, cover);
    }

    StickerItem(int id, int cover) {
        this.id = id;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public int getCover() {
        return cover;
    }
}
