package com.example.videoeditor.entities;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class NewTheme {
    private final int cover;
    private final String name;
    private final int icon;

    public NewTheme(int cover, String name, int icon) {
        this.cover = cover;
        this.name = name;
        this.icon = icon;
    }

    public static NewTheme create(@DrawableRes int cover, String name, @DrawableRes int icon) {
        return new NewTheme(cover, name, icon);
    }

    public int getCover() {
        return cover;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }
}
