package com.example.videoeditor.feature.edit.export;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityExportingBinding;
import com.example.videoeditor.feature.edit.result.ResultActivity;
import com.example.videoeditor.view.AnimationTextView;
import com.github.florent37.viewanimator.ViewAnimator;

public class ExportingActivity extends BaseActivityBinding<ActivityExportingBinding> {

    public static void open(Context context) {
        context.startActivity(new Intent(context, ExportingActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        binding.btCancel.setOnClickListener(v -> finish());
    }

    @Override
    protected ViewBinding binding() {
        return ActivityExportingBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {

        ViewAnimator.animate(binding.ivAnimation).alpha(0.5f, 1).duration(800).repeatMode(ViewAnimator.REVERSE).repeatCount(-1).start();

        binding.tvPercent.resetAnimation();
        binding.tvPercent.countAnimation(3, 100);
        binding.tvPercent.setAnimationDuration(8000);
        binding.tvPercent.setStringFormat("%s%%");
        binding.tvPercent.setCountAnimationListener(new AnimationTextView.CountAnimationListener() {
            @Override
            public void onAnimationEnd(Object animatedValue) {
                if (isFinishing()) {
                    return;
                }
                ResultActivity.open(ExportingActivity.this);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
