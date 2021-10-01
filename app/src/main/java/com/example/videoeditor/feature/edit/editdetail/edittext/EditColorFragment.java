package com.example.videoeditor.feature.edit.editdetail.edittext;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentEditColorBinding;
import com.example.videoeditor.entities.EditColorItem;
import com.example.videoeditor.util.SpacesItemDecoration;
import com.example.videoeditor.util.Util;

import java.util.Arrays;
import java.util.List;

public class EditColorFragment extends BaseFragmentBinding<FragmentEditColorBinding> {
    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
        initColor();
        initBorderColor();
    }

    private void initBorderColor() {
        List<EditColorItem> colors = Arrays.asList(
                EditColorItem.createColorItem(R.color.white, R.color.primary),
                EditColorItem.createColorItem(R.color.white, R.color.orange),
                EditColorItem.createColorItem(R.color.white, R.color.orange_op95),
                EditColorItem.createColorItem(R.color.white, R.color.cardview_shadow_start_color)
        );
        LinearLayoutManager layout = new LinearLayoutManager(context);
        layout.setOrientation(RecyclerView.HORIZONTAL);
        binding.rvFontBorderColor.setLayoutManager(layout);

        EditColorAdapter adapter = new EditColorAdapter();
        binding.rvFontBorderColor.setAdapter(adapter);
        binding.rvFontBorderColor.addItemDecoration(new SpacesItemDecoration(Util.dimenToPixel(context, R.dimen.px8)));
        adapter.setCallback(new EditColorAdapter.Callback() {
            @Override
            public void onItemChoose(EditColorItem editColorItem) {
                // TODO: 9/30/2021 color choose
            }
        });
        adapter.setData(colors);
    }

    private void initColor() {
        List<EditColorItem> colors = Arrays.asList(
                EditColorItem.createColorItem(R.color.black),
                EditColorItem.createColorItem(R.color.white),
                EditColorItem.createColorItem(R.color.orange),
                EditColorItem.createColorItem(R.color.orange_op95),
                EditColorItem.createColorItem(R.color.cardview_shadow_start_color)
        );
        LinearLayoutManager layout = new LinearLayoutManager(context);
        layout.setOrientation(RecyclerView.HORIZONTAL);
        binding.rvFontColor.setLayoutManager(layout);
        binding.rvFontColor.addItemDecoration(new SpacesItemDecoration(Util.dimenToPixel(context, R.dimen.px8)));

        EditColorAdapter adapter = new EditColorAdapter();
        binding.rvFontColor.setAdapter(adapter);
        adapter.setCallback(new EditColorAdapter.Callback() {
            @Override
            public void onItemChoose(EditColorItem editColorItem) {
                // TODO: 9/30/2021 color choose
            }
        });
        adapter.setData(colors);
    }

    @Override
    protected ViewBinding binding() {
        return FragmentEditColorBinding.inflate(getLayoutInflater());
    }
}
