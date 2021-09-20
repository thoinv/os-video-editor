package com.example.videoeditor.feature.edit.editdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityEditTransitionBinding;

public class EditTransitionActivity extends BaseActivityBinding<ActivityEditTransitionBinding> {
    public static void open(Context context) {
        context.startActivity(new Intent(context, EditTransitionActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        binding.btCancel.setOnClickListener(v -> finish());
        binding.btSave.setOnClickListener(v -> {
            // TODO: 9/20/2021 save transition config
            finish();
        });
    }

    @Override
    protected ViewBinding binding() {
        return ActivityEditTransitionBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {

    }
}
