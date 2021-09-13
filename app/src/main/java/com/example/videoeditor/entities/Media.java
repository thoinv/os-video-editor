package com.example.videoeditor.entities;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

public class Media implements Serializable {
    private int mediaResourceId;

    Media() {

    }

    Media(int mediaResourceId) {
        this.mediaResourceId = mediaResourceId;
    }

    public static Media createObject(@DrawableRes int mediaResourceId) {
        return new Media(mediaResourceId);
    }

    public int getMediaResourceId() {
        return mediaResourceId;
    }

    public void setMediaResourceId(@DrawableRes int mediaResourceId) {
        this.mediaResourceId = mediaResourceId;
    }
}
