package com.example.videoeditor.feature.edit.theme;

import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentEditThemeBinding;
import com.example.videoeditor.entities.ThemeItem;
import com.example.videoeditor.feature.main.NewThemeAdapter;

import java.util.Arrays;
import java.util.List;

public class EditThemeFragment extends BaseFragmentBinding<FragmentEditThemeBinding> {
    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
        List<ThemeItem> themeItems = Arrays.asList(
                ThemeItem.createNone()
        );
        ThemeAdapter themeAdapter = new ThemeAdapter();
        binding.rvTheme.setAdapter(themeAdapter);
        themeAdapter.setData(themeItems);
    }

    @Override
    protected ViewBinding binding() {
        return FragmentEditThemeBinding.inflate(getLayoutInflater());
    }
}
