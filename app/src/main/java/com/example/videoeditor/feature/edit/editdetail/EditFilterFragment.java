package com.example.videoeditor.feature.edit.editdetail;

import android.os.Bundle;

import androidx.core.text.HtmlCompat;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentEditFilterBinding;
import com.example.videoeditor.entities.FilterGroupItem;
import com.example.videoeditor.entities.FilterItem;
import com.example.videoeditor.entities.Media;
import com.example.videoeditor.entities.TransitionItem;
import com.example.videoeditor.feature.edit.editdetail.editfilter.EditFilterAdapter;
import com.example.videoeditor.feature.edit.editdetail.edittext.EditColorAdapter;
import com.example.videoeditor.feature.edit.editdetail.edittransition.EditTransitionAdapter;
import com.example.videoeditor.feature.edit.editdetail.edittransition.EditVideoTransitionAdapter;
import com.example.videoeditor.feature.recent.RecentCacheData;
import com.example.videoeditor.util.SpacesItemDecoration;
import com.example.videoeditor.util.Util;

import java.util.Arrays;
import java.util.List;

public class EditFilterFragment extends BaseFragmentBinding<FragmentEditFilterBinding> {
    private EditVideoTransitionAdapter editClipAdapter;
    private List<FilterGroupItem> grapefruit;

    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
        initClip();

        initFilterData();
        initFilter();
    }

    private void initFilterData() {
        grapefruit = Arrays.asList(
                FilterGroupItem.createNone(),
                FilterGroupItem.createItem(1, "Grapefruit", R.drawable.filter_group_ic_1,
                        Arrays.asList(
                                FilterItem.createItem(1, "Grapefruit Item 1", R.drawable.filter_ic_1),
                                FilterItem.createItem(2, "Grapefruit Item 2", R.drawable.filter_ic_1),
                                FilterItem.createItem(3, "Grapefruit Item 3", R.drawable.filter_ic_1)
                        )
                ), FilterGroupItem.createItem(1, "Grapefruit 2", R.drawable.filter_group_ic_1,
                        Arrays.asList(
                                FilterItem.createItem(1, "Grapefruit 2 Item 1", R.drawable.filter_ic_1),
                                FilterItem.createItem(2, "Grapefruit 2 Item 2", R.drawable.filter_ic_1),
                                FilterItem.createItem(3, "Grapefruit 2 Item 3", R.drawable.filter_ic_1),
                                FilterItem.createItem(4, "Grapefruit 2 Item 4", R.drawable.filter_ic_1),
                                FilterItem.createItem(5, "Grapefruit 2 Item 5", R.drawable.filter_ic_1)
                        )
                )
        );
    }

    private void initFilter() {
        EditFilterAdapter filterAdapter = new EditFilterAdapter();
        binding.rvFilter.setAdapter(filterAdapter);
        binding.rvFilter.addItemDecoration(new SpacesItemDecoration(Util.dimenToPixel(context, R.dimen.px6)));
        filterAdapter.setData(grapefruit);
    }

    private void initClip() {
        List<Media> selectedItems = RecentCacheData.instance().getSelectedItems();
        String source = String.format(getString(R.string.clip_number_format), selectedItems.size());
        binding.tvNumberOfMedia.setText(HtmlCompat.fromHtml(source, HtmlCompat.FROM_HTML_MODE_LEGACY));
        editClipAdapter = new EditVideoTransitionAdapter();
        binding.rvClips.setAdapter(editClipAdapter);
        editClipAdapter.setData(selectedItems);
        binding.rvClips.addItemDecoration(new SpacesItemDecoration(Util.dimenToPixel(getContext(), R.dimen.px4)));
    }

    @Override
    protected ViewBinding binding() {
        return FragmentEditFilterBinding.inflate(getLayoutInflater());
    }
}
