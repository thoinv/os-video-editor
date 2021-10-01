package com.example.videoeditor.feature.edit.music;

import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentMusicBinding;
import com.example.videoeditor.entities.TextStyleItem;
import com.example.videoeditor.feature.edit.editdetail.edittext.EditStyleAdapter;

import java.util.Arrays;
import java.util.List;

public class MusicFragment extends BaseFragmentBinding<FragmentMusicBinding> {
    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
        List<TextStyleItem> textStyles = Arrays.asList(
                TextStyleItem.createNone(),
                TextStyleItem.create("test 1", R.drawable.edit_music_ic_1),
                TextStyleItem.create("test 1", R.drawable.edit_music_ic_2),
                TextStyleItem.create("test 1", R.drawable.edit_music_ic_3)
        );
        EditStyleAdapter adapter = new EditStyleAdapter();
        binding.rvStyle.setAdapter(adapter);
        adapter.setData(textStyles);
    }

    @Override
    protected ViewBinding binding() {
        return FragmentMusicBinding.inflate(getLayoutInflater());
    }
}
