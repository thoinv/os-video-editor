package com.example.videoeditor.feature.edit.editdetail.edittext;

import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentTextStyleBinding;
import com.example.videoeditor.entities.TextStyleItem;

import java.util.Arrays;
import java.util.List;

public class EditTextStyleFragment extends BaseFragmentBinding<FragmentTextStyleBinding> {

    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
        List<TextStyleItem> textStyles = Arrays.asList(
                TextStyleItem.createNone(),
                TextStyleItem.create("test 1", R.drawable.edit_style_1),
                TextStyleItem.create("test 1", R.drawable.edit_style_2),
                TextStyleItem.create("test 1", R.drawable.edit_style_3)
        );
        EditStyleAdapter adapter = new EditStyleAdapter();
        binding.rvStyle.setAdapter(adapter);
        adapter.setData(textStyles);
    }

    @Override
    protected ViewBinding binding() {
        return FragmentTextStyleBinding.inflate(getLayoutInflater());
    }
}
