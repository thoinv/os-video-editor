package com.example.videoeditor.entities;

import com.example.videoeditor.R;

import java.util.Collections;
import java.util.List;

public class FilterGroupItem {

    public static FilterGroupItem createNone() {
        return new FilterGroupItem(0, "none", R.drawable.all_ic_none, Collections.emptyList());
    }

    public static FilterGroupItem createItem(int id, String name, int cover, List<FilterItem> filterItems) {
        return new FilterGroupItem(id, name, cover, filterItems);
    }

    public FilterGroupItem(int id, String name, int cover, List<FilterItem> filterItems) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.filterItems = filterItems;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCover() {
        return cover;
    }

    public List<FilterItem> getFilterItems() {
        return filterItems;
    }

    private final int id;
    private final String name;
    private final int cover;
    private final List<FilterItem> filterItems;

    public boolean isNone() {
        return "none".equalsIgnoreCase(name);
    }
}
