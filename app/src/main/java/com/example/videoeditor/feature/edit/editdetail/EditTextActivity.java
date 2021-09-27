package com.example.videoeditor.feature.edit.editdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityEditTextBinding;
import com.example.videoeditor.util.DeviceUtil;

public class EditTextActivity extends BaseActivityBinding<ActivityEditTextBinding> {

    public static void open(Context context) {
        context.startActivity(new Intent(context, EditTextActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        binding.layoutToolbar.btSave.setOnClickListener(v -> {
        });

        binding.layoutToolbar.btCancel.setOnClickListener(v -> {
        });
        binding.menuKeyboard.setOnClickListener(v -> {
            binding.edText.requestFocus();
            DeviceUtil.showKeyboard(binding.edText);
        });
    }

    @Override
    protected ViewBinding binding() {
        return ActivityEditTextBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {
        binding.layoutToolbar.tvToolbarTitle.setText(R.string.text);
    }
}
