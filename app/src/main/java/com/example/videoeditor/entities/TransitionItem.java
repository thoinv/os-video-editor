package com.example.videoeditor.entities;

import com.example.videoeditor.R;

public class TransitionItem {
    private final int id;
    private final int cover;
    private final String name;

    TransitionItem(int id, int cover, String name) {
        this.id = id;
        this.cover = cover;
        this.name = name;
    }

    public static TransitionItem createItem(int id, int cover, String name) {
        return new TransitionItem(id, cover, name);
    }

    public static TransitionItem createNone() {
        return new TransitionItem(0, R.drawable.transition_ic_none, "None");
    }

    public int getId() {
        return id;
    }

    public int getCover() {
        return cover;
    }

    public String getName() {
        return name;
    }

    public boolean isNone() {
        return "None".equalsIgnoreCase(name);
    }
}
