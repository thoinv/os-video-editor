package com.example.videoeditor.feature.recent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class RecentTabAdapter extends FragmentStateAdapter {
    private final Set<RecentContentFragment> fragments = new LinkedHashSet<>();
    private boolean isLoaded;
    private boolean isLoading;

    public RecentTabAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        RecentContentFragment fragment = new RecentContentFragment();
        fragments.add(fragment);
        return fragment;
    }

    public RecentContentFragment getFragmentByPosition(int position) {
        return new ArrayList<>(fragments).get(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void load() {
    }
}