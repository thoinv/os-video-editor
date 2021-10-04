package com.example.videoeditor.feature.edit.editdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityEditDetailBinding;
import com.example.videoeditor.feature.edit.editdetail.editduration.EditDurationActivity;
import com.example.videoeditor.feature.edit.editdetail.editsticker.EditStickerFragment;
import com.example.videoeditor.feature.edit.editdetail.edittransition.EditTransitionActivity;
import com.example.videoeditor.util.Util;

public class EditDetailActivity extends BaseActivityBinding<ActivityEditDetailBinding> {

    private EditStickerFragment editStickerFragment;
    private EditFilterFragment editFilterFragment;
    private Fragment currentFragment;
    private Fragment prevFragment;

    public static void open(Context context) {
        context.startActivity(new Intent(context, EditDetailActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        View.OnClickListener onButtonClicked = v -> {
            int id = v.getId();
            Util.changeFilterButtonColor(binding.ivFilter, binding.tvFilter, R.color.white);

            if (id == R.id.bottom_menu_duration) {
                onButtonMenuDurationClicked();
            } else if (id == R.id.bottom_menu_filter) {
                onButtonMenuFilterClicked();

            } else if (id == R.id.bottom_menu_sticker) {
                onButtonMenuStickerClicked();

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
        binding.bottomMenuSticker.setOnClickListener(onButtonClicked);
        binding.bottomMenuTransition.setOnClickListener(onButtonClicked);
        binding.bottomMenuZoom.setOnClickListener(onButtonClicked);
        binding.bottomMenuText.setOnClickListener(onButtonClicked);

        binding.layoutToolbar.btToolbarBack.setOnClickListener(v -> {
            finish();
        });
        binding.layoutToolbar.tvToolbarTitle.setText(R.string.edit);
    }

    private void onButtonMenuFilterClicked() {
        Util.changeFilterButtonColor(binding.ivSticker, binding.tvSticker, R.color.white);
        Util.changeFilterButtonColor(binding.ivFilter, binding.tvFilter, R.color.orange);
        showFragment(editFilterFragment);
    }

    private void onButtonMenuStickerClicked() {
        Util.changeFilterButtonColor(binding.ivFilter, binding.tvFilter, R.color.white);
        Util.changeFilterButtonColor(binding.ivSticker, binding.tvSticker, R.color.orange);
        showFragment(editStickerFragment);
    }

    private void onButtonMenuZoomClicked() {

    }

    private void onButtonMenuTextClicked() {
        EditTextActivity.open(this);
        Util.changeFilterButtonColor(binding.ivFilter, binding.tvFilter, R.color.white);
        Util.changeFilterButtonColor(binding.ivSticker, binding.tvSticker, R.color.white);
    }

    private void onButtonMenuDurationClicked() {
        EditDurationActivity.open(this);
        Util.changeFilterButtonColor(binding.ivFilter, binding.tvFilter, R.color.white);
        Util.changeFilterButtonColor(binding.ivSticker, binding.tvSticker, R.color.white);
    }

    @Override
    protected ViewBinding binding() {
        return ActivityEditDetailBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {
        editStickerFragment = new EditStickerFragment();
        editFilterFragment = new EditFilterFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, editStickerFragment)
                .hide(editStickerFragment)
                .add(R.id.container, editFilterFragment)
                .hide(editFilterFragment)
                .commitAllowingStateLoss();
    }

    private void hideFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(fragment).commitAllowingStateLoss();
    }

    private void showFragment(Fragment fragment) {
        if (fragment == currentFragment) {
            return;
        }
        prevFragment = currentFragment;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (prevFragment != null) {
            fragmentTransaction.hide(prevFragment);
        }
        fragmentTransaction.show(fragment).commitAllowingStateLoss();
        currentFragment = fragment;
    }
}