package com.example.videoeditor.feature.edit.result;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityResultBinding;

public class ResultActivity extends BaseActivityBinding<ActivityResultBinding> {
    public static void open(Context context) {
        context.startActivity(new Intent(context, ResultActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected ViewBinding binding() {
        return ActivityResultBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {

    }
}
