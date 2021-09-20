package com.example.videoeditor.feature.edit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityEditBinding;

public class EditActivity extends BaseActivityBinding<ActivityEditBinding> {

    public static void open(Context context) {
        context.startActivity(new Intent(context, EditActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected ViewBinding binding() {
        return ActivityEditBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {

    }
}
