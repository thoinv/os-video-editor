package com.example.videoeditor.feature.recent;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.videoeditor.entities.Media;

import java.util.ArrayList;
import java.util.List;

class RecentCacheData {
    private static RecentCacheData instance;
    private final MutableLiveData<List<Media>> liveDataSelectItems = new MutableLiveData<>();

    public static RecentCacheData instance() {
        if (instance == null) {
            instance = new RecentCacheData();
        }
        return instance;
    }

    public void updateItem(Media media) {
        List<Media> mediaList = liveDataSelectItems.getValue();
        if (mediaList == null) {
            mediaList = new ArrayList<>();
            mediaList.add(media);
        } else {
            if (mediaList.contains(media)) {
                mediaList.remove(media);
            } else {
                mediaList.add(media);
            }
        }
        liveDataSelectItems.postValue(mediaList);
    }

    public List<Media> getSelectedItems() {
        return liveDataSelectItems.getValue();
    }

    public void getSelectedItemsObservable(Context context, Observer<List<Media>> listObserver) {
        liveDataSelectItems.observe((LifecycleOwner) context, listObserver);
    }

    public boolean containValue(Media media) {
        List<Media> selectedItems = getSelectedItems();
        if (selectedItems == null || selectedItems.isEmpty()) {
            return false;
        }
        return selectedItems.contains(media);
    }

    public void clear() {
        liveDataSelectItems.setValue(null);
    }
}
