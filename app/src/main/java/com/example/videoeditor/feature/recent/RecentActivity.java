package com.example.videoeditor.feature.recent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityRecentBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class RecentActivity extends BaseActivityBinding<ActivityRecentBinding> {
    public static void open(Context context) {
        context.startActivity(new Intent(context, RecentActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        binding.btToolbarBack.setOnClickListener(v -> finish());
        binding.btChooseMediaSource.setOnClickListener(v -> {
            // TODO: 9/12/2021 choose media source
        });
    }

    @Override
    protected void initViews(Bundle bundle) {
        List<Integer> tabTitles = Arrays.asList(R.string.all, R.string.video, R.string.images);
        RecentTabAdapter adapter = new RecentTabAdapter(this);
        binding.vpContent.setAdapter(adapter);
        binding.vpContent.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                RecentTabAdapter userContentAdapter = (RecentTabAdapter) binding.vpContent.getAdapter();
                if (userContentAdapter.isLoaded() || userContentAdapter.isLoading()) {
                    return;
                }
                userContentAdapter.load();
            }
        });
        new TabLayoutMediator(binding.tabs, binding.vpContent,
                (tab, position) -> {
                    tab.setText(tabTitles.get(position));
                    tab.select();
                }
        ).attach();
    }

    @Override
    protected ViewBinding binding() {
        return ActivityRecentBinding.inflate(getLayoutInflater());
    }
}
