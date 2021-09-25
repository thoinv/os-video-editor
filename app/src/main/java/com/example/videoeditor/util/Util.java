package com.example.videoeditor.util;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;

public class Util {
    public static int dimenToPixel(Context context, int dimenResourceId) {
        return context.getResources().getDimensionPixelSize(dimenResourceId);
    }

    public static void changeFilterButtonColor(ImageView icon, TextView textView, @ColorRes int color) {
        Context context = icon.getContext();
        icon.setColorFilter(ContextCompat.getColor(context, color), android.graphics.PorterDuff.Mode.SRC_IN);
        textView.setTextColor(ContextCompat.getColor(context, color));
    }
}
