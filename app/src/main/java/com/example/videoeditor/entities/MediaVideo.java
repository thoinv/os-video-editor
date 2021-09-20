package com.example.videoeditor.entities;

import androidx.annotation.DrawableRes;

public class MediaVideo extends Media {
    public MediaVideo(int mediaResourceId) {
        super(mediaResourceId);
    }

    public static MediaVideo createObject(@DrawableRes int mediaResourceId) {
        return new MediaVideo(mediaResourceId);
    }
}
