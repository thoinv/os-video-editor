package com.example.videoeditor;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.base.IAdapterCallback;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityMainBinding;
import com.example.videoeditor.entities.NewTheme;
import com.example.videoeditor.feature.main.NewThemeAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivityBinding<ActivityMainBinding> {

    @Override
    protected ViewBinding binding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {
        List<NewTheme> newThemes = Arrays.asList(
                NewTheme.create(R.drawable.ic_fx, "Fx", R.drawable.theme_vector_fx),
                NewTheme.create(R.drawable.ic_effect, "Hiệu ứng", R.drawable.theme_vector_effect),
                NewTheme.create(R.drawable.ic_text, "Văn bản", R.drawable.theme_vector_text),
                NewTheme.create(R.drawable.ic_sticker, "Hình dán", R.drawable.theme_vector_sticker)
        );
        binding.rvNewThemes.setLayoutManager(new GridLayoutManager(this, 2));
        NewThemeAdapter newThemeAdapter = new NewThemeAdapter(newThemes)
                .setCallback(new IAdapterCallback<NewTheme>() {
                    @Override
                    public void onItemClicked(NewTheme newTheme, int position) {

                    }
                });
        binding.rvNewThemes.setAdapter(newThemeAdapter);
    }

}