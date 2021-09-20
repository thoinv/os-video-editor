package com.example.videoeditor.entities;

import androidx.annotation.DrawableRes;

public class MediaImage extends Media {
    public MediaImage(int mediaResourceId) {
        super(mediaResourceId);
    }

    public static MediaImage createObject(@DrawableRes int mediaResourceId) {
        return new MediaImage(mediaResourceId);
    }

}
