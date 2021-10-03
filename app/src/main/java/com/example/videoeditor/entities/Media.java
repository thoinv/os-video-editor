package com.example.videoeditor.entities;

import androidx.annotation.DrawableRes;

import com.example.videoeditor.R;

import java.io.Serializable;

public class Media implements Serializable {
    private int mediaResourceId;
    private TransitionItem transitionItem;
    private int duration;

    Media() {

    }

    protected Media(int mediaResourceId) {
        this.mediaResourceId = mediaResourceId;
    }

    public int getMediaResourceId() {
        return mediaResourceId;
    }

    public void setMediaResourceId(@DrawableRes int mediaResourceId) {
        this.mediaResourceId = mediaResourceId;
    }

    public int getMediaTypeIconResource() {
        if (this instanceof MediaVideo) {
            return R.drawable.all_vector_video_type;
        }
        return R.drawable.all_vector_image_type;
    }

    public void setTransitionItem(TransitionItem transitionItem) {
        this.transitionItem = transitionItem;
    }

    public TransitionItem getTransitionItem() {
        return transitionItem;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
