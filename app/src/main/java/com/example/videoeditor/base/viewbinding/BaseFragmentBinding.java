package com.example.videoeditor.base.viewbinding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import org.jetbrains.annotations.NotNull;

public abstract class BaseFragmentBinding<T extends ViewBinding> extends Fragment {
    protected Context context;
    protected T binding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            binding = (T) this.binding();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.initViews(savedInstanceState);
        this.bindViewClickEvent();
        return this.binding.getRoot();
    }

    protected abstract void bindViewClickEvent();

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (isVisible()) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public boolean useEventBus() {
        return false;
    }

    protected abstract void initViews(Bundle bundle);

    protected abstract ViewBinding binding();

    public void finishActivity() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

}
