package com.example.videoeditor.feature.edit.editdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityEditDetailBinding;

public class EditDetailActivity extends BaseActivityBinding<ActivityEditDetailBinding> {

    public static void open(Context context) {
        context.startActivity(new Intent(context, EditDetailActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        View.OnClickListener onButtonClicked = v -> {
            int id = v.getId();
            changeFilterButtonColor(R.color.white);

            if (id == R.id.bottom_menu_duration) {
                onButtonMenuDurationClicked();
            } else if (id == R.id.bottom_menu_filter) {
                onButtonMenuFilterClicked();

            } else if (id == R.id.bottom_menu_music) {
                onButtonMenuMusicClicked();

            } else if (id == R.id.bottom_menu_transition) {
                EditTransitionActivity.open(this);

            } else if (id == R.id.bottom_menu_zoom) {
                onButtonMenuZoomClicked();

            } else if (id == R.id.bottom_menu_text) {
                onButtonMenuTextClicked();

            }
        };
        binding.bottomMenuDuration.setOnClickListener(onButtonClicked);
        binding.bottomMenuFilter.setOnClickListener(onButtonClicked);
        binding.bottomMenuMusic.setOnClickListener(onButtonClicked);
        binding.bottomMenuTransition.setOnClickListener(onButtonClicked);
        binding.bottomMenuZoom.setOnClickListener(onButtonClicked);
        binding.bottomMenuText.setOnClickListener(onButtonClicked);

        binding.layoutToolbar.btToolbarBack.setOnClickListener(v -> {
            finish();
        });
        binding.layoutToolbar.tvToolbarTitle.setText(R.string.edit);
    }

    private void onButtonMenuFilterClicked() {
        changeFilterButtonColor(R.color.orange);
    }

    private void changeFilterButtonColor(@ColorRes int color) {
        binding.ivFilter.setColorFilter(ContextCompat.getColor(this, color), android.graphics.PorterDuff.Mode.SRC_IN);
        binding.tvFilter.setTextColor(ContextCompat.getColor(this, color));
    }

    private void onButtonMenuMusicClicked() {

    }

    private void onButtonMenuZoomClicked() {

    }

    private void onButtonMenuTextClicked() {

    }

    private void onButtonMenuDurationClicked() {
        EditDurationActivity.open(this);
    }

    @Override
    protected ViewBinding binding() {
        return ActivityEditDetailBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {

    }
}