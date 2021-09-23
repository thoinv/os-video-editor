package com.example.videoeditor.feature.edit.result;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class ShareItem {
    ShareItem(int iconResId, int stringResId) {
        this.iconResId = iconResId;
        this.stringResId = stringResId;
    }

    public static ShareItem create(@DrawableRes int iconResId, @StringRes int stringResId) {
        return new ShareItem(iconResId, stringResId);
    }

    public int getIconResId() {
        return iconResId;
    }

    public int getStringResId() {
        return stringResId;
    }

    private final int iconResId;
    private final int stringResId;
}
