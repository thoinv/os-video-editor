package com.example.videoeditor.feature.edit.editdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spanned;
import android.widget.SeekBar;

import androidx.core.text.HtmlCompat;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityEditDurationBinding;

public class EditDurationActivity extends BaseActivityBinding<ActivityEditDurationBinding> {

    public static void open(Context context) {
        context.startActivity(new Intent(context, EditDurationActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        binding.layoutToolbar.btCancel.setOnClickListener(v -> {
            finish();
        });
        binding.layoutToolbar.btSave.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected ViewBinding binding() {
        return ActivityEditDurationBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {
        binding.layoutToolbar.tvToolbarTitle.setText(R.string.duration);
        // FIXME: 9/25/2021 duration calc
        updateDuration("10s");
        binding.tvDurationStart.setText("0s");
        binding.tvDurationEnd.setText("10s");
        binding.sbDuration.setMax(10);
        binding.sbDuration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateDuration(progress + "s");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void updateDuration(String duration) {
        Spanned durationTotal = HtmlCompat.fromHtml(String.format(getString(R.string.edit_duration_total), duration), HtmlCompat.FROM_HTML_MODE_LEGACY);
        binding.tvDuration.setText(durationTotal);
    }
}
