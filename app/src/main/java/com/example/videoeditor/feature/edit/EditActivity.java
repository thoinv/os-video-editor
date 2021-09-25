package com.example.videoeditor.feature.edit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityEditBinding;
import com.example.videoeditor.feature.edit.editdetail.EditDetailActivity;
import com.example.videoeditor.feature.edit.export.ExportActivity;
import com.example.videoeditor.util.Util;

public class EditActivity extends BaseActivityBinding<ActivityEditBinding> {

    public static void open(Context context) {
        context.startActivity(new Intent(context, EditActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        binding.layoutToolbar.btToolbarBack.setOnClickListener(v -> finish());
        binding.btPlay.setOnClickListener(v -> onButtonPlayClicked());
        View.OnClickListener bottomMenuOnClickListener = v -> {
            Util.changeFilterButtonColor(binding.ivEffect, binding.tvEffect, R.color.gray_bottom_menu);
            Util.changeFilterButtonColor(binding.ivMusic, binding.tvMusic, R.color.gray_bottom_menu);
            binding.layoutToolbarExport.getRoot().setVisibility(View.GONE);

            int id = v.getId();
            if (id == R.id.bottom_menu_edit) {
                EditDetailActivity.open(this);

            } else if (id == R.id.bottom_menu_effect) {
                onBottomMenuEffectClicked();

            } else if (id == R.id.bottom_menu_music) {
                onBottomMenuMusicClicked();

            } else if (id == R.id.bottom_menu_theme) {
                onBottomMenuThemeClicked();
            }
        };
        binding.bottomMenuEdit.setOnClickListener(bottomMenuOnClickListener);
        binding.bottomMenuEffect.setOnClickListener(bottomMenuOnClickListener);
        binding.bottomMenuMusic.setOnClickListener(bottomMenuOnClickListener);
        binding.bottomMenuTheme.setOnClickListener(bottomMenuOnClickListener);
    }

    private void onButtonPlayClicked() {
        Toast.makeText(this, "onButtonPlayClicked", Toast.LENGTH_SHORT).show();

    }

    private void onBottomMenuThemeClicked() {
        Toast.makeText(this, "onBottomMenuThemeClicked", Toast.LENGTH_SHORT).show();
    }

    private void onBottomMenuMusicClicked() {
        Toast.makeText(this, "onBottomMenuMusicClicked", Toast.LENGTH_SHORT).show();
        Util.changeFilterButtonColor(binding.ivMusic, binding.tvMusic, R.color.orange);
        binding.layoutToolbarExport.getRoot().setVisibility(View.VISIBLE);
        binding.layoutToolbarExport.tvToolbarTitle.setText(R.string.music);
        binding.layoutToolbarExport.btExport.setOnClickListener(v -> {
            ExportActivity.open(this);
        });
    }

    private void onBottomMenuEffectClicked() {
        Toast.makeText(this, "onBottomMenuEffectClicked", Toast.LENGTH_SHORT).show();
        Util.changeFilterButtonColor(binding.ivEffect, binding.tvEffect, R.color.orange);
    }

    @Override
    protected ViewBinding binding() {
        return ActivityEditBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {
        binding.layoutToolbar.tvToolbarTitle.setText(R.string.edit);
    }
}
