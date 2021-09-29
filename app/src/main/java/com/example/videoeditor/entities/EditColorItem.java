package com.example.videoeditor.entities;

public class EditColorItem {
    public EditColorItem(int color, int colorBorder) {
        this.color = color;
        this.colorBorder = colorBorder;
    }

    public static EditColorItem createColorItem(int color) {
        return createColorItem(color, -1);
    }

    public static EditColorItem createColorItem(int color, int border) {
        return new EditColorItem(color, border);
    }

    public int getColor() {
        return color;
    }

    public int getColorBorder() {
        return colorBorder;
    }

    private final int color;
    private final int colorBorder;
}
