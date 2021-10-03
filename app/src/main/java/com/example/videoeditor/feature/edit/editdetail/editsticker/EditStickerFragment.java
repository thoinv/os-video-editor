package com.example.videoeditor.feature.edit.editdetail.editsticker;

import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentEditStickerBinding;
import com.example.videoeditor.entities.EffectItem;
import com.example.videoeditor.entities.StickerItem;
import com.example.videoeditor.feature.edit.effect.EditEffectGroupAdapter;
import com.example.videoeditor.util.GridSpacingItemDecoration;
import com.example.videoeditor.util.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditStickerFragment extends BaseFragmentBinding<FragmentEditStickerBinding> {
    private final Map<String, List<StickerItem>> stickerMap = new HashMap<>();
    private EditStickerAdapter editStickerAdapter;

    @Override
    protected void bindViewClickEvent() {
        binding.toolbar.btCancel.setOnClickListener(v -> {
            // TODO: 10/4/2021 cancel
        });
        binding.toolbar.btSave.setOnClickListener(v -> {
            // TODO: 10/4/2021 save
        });
    }

    @Override
    protected void initViews(Bundle bundle) {

        initData();
        initSticker();
        initGroup();
    }

    private void initSticker() {
        editStickerAdapter = new EditStickerAdapter();
        binding.rvSticker.setAdapter(editStickerAdapter);
        GridSpacingItemDecoration spacingItemDecoration = new GridSpacingItemDecoration(4, Util.dimenToPixel(context, R.dimen.px10), false);
        binding.rvSticker.addItemDecoration(spacingItemDecoration);
    }

    private void initGroup() {
        EditStickerGroupAdapter adapter = new EditStickerGroupAdapter();
        binding.rvEffectGroup.setAdapter(adapter);
        adapter.setCallback((position, stickerItems) -> {
            if (editStickerAdapter != null) {
                editStickerAdapter.setData(stickerItems);
            }
        });
        adapter.setData(stickerMap);
    }

    private void initData() {

        List<StickerItem> effectItems = Arrays.asList(
                StickerItem.createItem(1, R.drawable.sticker_ic_1),
                StickerItem.createItem(2, R.drawable.sticker_ic_2),
                StickerItem.createItem(3, R.drawable.sticker_ic_3),
                StickerItem.createItem(4, R.drawable.sticker_ic_4),
                StickerItem.createItem(5, R.drawable.sticker_ic_5));
        stickerMap.put("GIF", effectItems);
        List<StickerItem> trendy = Arrays.asList(
                StickerItem.createItem(5, R.drawable.sticker_ic_3),
                StickerItem.createItem(76, R.drawable.sticker_ic_5),
                StickerItem.createItem(5, R.drawable.sticker_ic_6));
        stickerMap.put("Trendy", trendy);
        List<StickerItem> emoji = Arrays.asList(
                StickerItem.createItem(512, R.drawable.sticker_ic_1),
                StickerItem.createItem(612, R.drawable.sticker_ic_6),
                StickerItem.createItem(512, R.drawable.sticker_ic_3),
                StickerItem.createItem(513, R.drawable.sticker_ic_1),
                StickerItem.createItem(614, R.drawable.sticker_ic_6),
                StickerItem.createItem(6141, R.drawable.sticker_ic_1),
                StickerItem.createItem(5112, R.drawable.sticker_ic_3));
        stickerMap.put("Emoji", emoji);
    }

    @Override
    protected ViewBinding binding() {
        return FragmentEditStickerBinding.inflate(getLayoutInflater());
    }
}
