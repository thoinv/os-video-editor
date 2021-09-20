package com.example.videoeditor.util;

import android.content.Context;

public class Util {
    public static int dimenToPixel(Context context, int dimenResourceId) {
        return context.getResources().getDimensionPixelSize(dimenResourceId);
    }
}
