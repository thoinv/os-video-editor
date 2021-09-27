package com.example.videoeditor.feature.edit.editdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityEditStickerBinding;

public class EditStickerActivity extends BaseActivityBinding<ActivityEditStickerBinding> {

    public static void open(Context context) {
        context.startActivity(new Intent(context, EditStickerActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected ViewBinding binding() {
        return ActivityEditStickerBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {

    }
}
