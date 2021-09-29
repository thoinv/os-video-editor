package com.example.videoeditor.feature.edit.editdetail.edittext;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentEditColorBinding;
import com.example.videoeditor.entities.EditColorItem;

import java.util.Arrays;
import java.util.List;

public class EditColorFragment extends BaseFragmentBinding<FragmentEditColorBinding> {
    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
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
