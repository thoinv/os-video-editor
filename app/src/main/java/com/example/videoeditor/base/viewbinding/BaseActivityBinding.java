package com.example.videoeditor.base.viewbinding;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;


import com.example.videoeditor.util.DeviceUtil;


public abstract class BaseActivityBinding<T extends ViewBinding> extends AppCompatActivity {
    public T binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String screenViewNameForTracking = getScreenViewNameForTracking();

        int windowFeature = onRequestWindowFeature();
        if (windowFeature > 0) {
            requestWindowFeature(windowFeature);
        }
        try {
            binding = (T) this.binding();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setContentView(binding.getRoot());

        int statusColor = getStatusColor();
        if (statusColor > 0) {
            DeviceUtil.changeStatusBarColor(this, statusColor, false);
        }
        this.initViews(savedInstanceState);
    }

    protected int getStatusColor() {
        return -1;
    }

    protected boolean useEventBus() {
        return false;
    }

    protected String getScreenViewNameForTracking() {
        return null;
    }

    protected abstract ViewBinding binding();

    protected int onRequestWindowFeature() {
        return -1;
    }

    protected abstract void initViews(Bundle bundle);

}
