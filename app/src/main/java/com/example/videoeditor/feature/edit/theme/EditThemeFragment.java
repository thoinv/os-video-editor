package com.example.videoeditor.feature.edit.theme;

import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentEditThemeBinding;
import com.example.videoeditor.entities.ThemeItem;
import com.example.videoeditor.feature.main.NewThemeAdapter;
import com.example.videoeditor.util.SpacesItemDecoration;
import com.example.videoeditor.util.Util;

import java.util.Arrays;
import java.util.List;

public class EditThemeFragment extends BaseFragmentBinding<FragmentEditThemeBinding> {
    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
        List<ThemeItem> themeItems = Arrays.asList(
                ThemeItem.createNone(),
                ThemeItem.createItem(1, "Daydream", R.drawable.theme_ic_1),
                ThemeItem.createItem(1, "Mother’s Day", R.drawable.theme_ic_1),
                ThemeItem.createItem(1, "Spring Time", R.drawable.theme_ic_1),
                ThemeItem.createItem(1, "Flash light", R.drawable.theme_ic_1)
        );
        ThemeAdapter themeAdapter = new ThemeAdapter();
        binding.rvTheme.setAdapter(themeAdapter);
        binding.rvTheme.addItemDecoration(new SpacesItemDecoration(Util.dimenToPixel(getContext(), R.dimen.px6)));
        themeAdapter.setData(themeItems);
    }

    @Override
    protected ViewBinding binding() {
        return FragmentEditThemeBinding.inflate(getLayoutInflater());
    }
}
