package com.example.videoeditor.feature.edit.export;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityExportingBinding;

public class ExportingActivity extends BaseActivityBinding<ActivityExportingBinding> {

    public static void open(Context context) {
        context.startActivity(new Intent(context, ExportingActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
    }

    @Override
    protected ViewBinding binding() {
        return ActivityExportingBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {

    }
}
