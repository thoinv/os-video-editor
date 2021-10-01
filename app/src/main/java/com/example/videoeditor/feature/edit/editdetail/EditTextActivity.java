package com.example.videoeditor.feature.edit.editdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityEditTextBinding;
import com.example.videoeditor.feature.edit.editdetail.edittext.EditColorFragment;
import com.example.videoeditor.feature.edit.editdetail.edittext.EditFontFragment;
import com.example.videoeditor.feature.edit.editdetail.edittext.EditTextCustomFragment;
import com.example.videoeditor.feature.edit.editdetail.edittext.EditTextStyleFragment;
import com.example.videoeditor.util.DeviceUtil;
import com.example.videoeditor.util.Util;

public class EditTextActivity extends BaseActivityBinding<ActivityEditTextBinding> {

    private EditTextStyleFragment styleFragment;
    private EditFontFragment fontFragment;
    private EditColorFragment editColorFragment;
    private EditTextCustomFragment editTextCustomFragment;
    private ImageView currentMenuCoverSelected;
    private TextView currentMenuTextSelected;
    private Fragment prevFragment;

    public static void open(Context context) {
        context.startActivity(new Intent(context, EditTextActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        binding.layoutToolbar.btSave.setOnClickListener(v -> {
            finish();
        });

        binding.layoutToolbar.btCancel.setOnClickListener(v -> {
            finish();
        });
        binding.menuFont.setOnClickListener(v -> {
            showFragment(binding.ivFont, binding.tvFont, fontFragment);
        });
        binding.menuKeyboard.setOnClickListener(v -> {
            showFragment(binding.ivKeyboard, binding.tvKeyboard, null);
        });
        binding.menuStyle.setOnClickListener(v -> {
            showFragment(binding.ivStyle, binding.tvStyle, styleFragment);
        });
        binding.menuCustom.setOnClickListener(v -> {
            showFragment(binding.ivCustom, binding.tvCustom, editTextCustomFragment);
        });
        binding.menuColor.setOnClickListener(v -> {
            showFragment(binding.ivColor, binding.tvColor, editColorFragment);
        });
    }

    private void showFragment(ImageView menuIcon, TextView menuText, Fragment fragment) {
        if (fragment != null && fragment == prevFragment && menuIcon != binding.ivKeyboard) {
            return;
        }
        ImageView prevMenuCoverSelected = currentMenuCoverSelected;
        TextView prevMenuTextSelected = currentMenuTextSelected;

        if (prevMenuTextSelected != null) {
            Util.changeFilterButtonColor(prevMenuCoverSelected, prevMenuTextSelected, R.color.white);
        }
        Util.changeFilterButtonColor(menuIcon, menuText, R.color.orange);

        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.show(fragment);
            if (prevFragment != null) {
                fragmentTransaction.hide(prevFragment);
            }
            fragmentTransaction.commitAllowingStateLoss();
        }

        binding.container.setVisibility(View.VISIBLE);
        if (menuIcon == binding.ivKeyboard) {
            binding.container.setVisibility(View.GONE);
            binding.edText.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                if (binding == null) {
                    return;
                }
                binding.edText.requestFocus();
                DeviceUtil.showKeyboard(binding.edText);
            }, 300);

        } else {
            binding.container.setVisibility(View.VISIBLE);
            binding.viewFocus.clearFocus();
            DeviceUtil.hideKeyboard(binding.edText);
            binding.edText.setVisibility(View.GONE);
        }
        currentMenuCoverSelected = menuIcon;
        currentMenuTextSelected = menuText;
        prevFragment = fragment;
    }

    private void initFragments() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        styleFragment = new EditTextStyleFragment();
        fontFragment = new EditFontFragment();
        editColorFragment = new EditColorFragment();
        editTextCustomFragment = new EditTextCustomFragment();
        fragmentTransaction
                .add(R.id.container, styleFragment)
                .add(R.id.container, fontFragment)
                .add(R.id.container, editTextCustomFragment)
                .add(R.id.container, editColorFragment)
                .hide(styleFragment)
                .hide(fontFragment)
                .hide(editColorFragment)
                .hide(editTextCustomFragment)
                .commitAllowingStateLoss();
    }

    @Override
    protected ViewBinding binding() {
        return ActivityEditTextBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {
        binding.layoutToolbar.tvToolbarTitle.setText(R.string.text);
        initFragments();
        showFragment(binding.ivKeyboard, binding.tvKeyboard, null);
    }
}
