package com.example.videoeditor.feature.edit.export;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityExportBinding;
import com.example.videoeditor.feature.edit.EditActivity;

public class ExportActivity extends BaseActivityBinding<ActivityExportBinding> {

    public static void open(Context context) {
        context.startActivity(new Intent(context, ExportActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        binding.btExport.setOnClickListener(v -> ExportingActivity.open(this));
        binding.btPlay.setOnClickListener(v -> {
            // TODO: 9/22/2021 play video
        });
        binding.layoutToolbar.btToolbarBack.setOnClickListener(v -> finish());
    }

    @Override
    protected ViewBinding binding() {
        return ActivityExportBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {
        // FIXME: 9/22/2021 change export info
        String duration = "1 min";
        String estimateSize = "18MB";
        String resolution = "720p";

        String infoText = String.format(getString(R.string.export_info), duration, estimateSize, resolution);
        binding.tvExportInfo.setText(infoText);
    }
}
