package com.example.videoeditor.feature.edit.editdetail;

import android.os.Bundle;

import androidx.core.text.HtmlCompat;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentEditFilterBinding;
import com.example.videoeditor.entities.Media;
import com.example.videoeditor.entities.TransitionItem;
import com.example.videoeditor.feature.edit.editdetail.edittransition.EditTransitionAdapter;
import com.example.videoeditor.feature.edit.editdetail.edittransition.EditVideoTransitionAdapter;
import com.example.videoeditor.feature.recent.RecentCacheData;
import com.example.videoeditor.util.SpacesItemDecoration;
import com.example.videoeditor.util.Util;

import java.util.Arrays;
import java.util.List;

public class EditFilterFragment extends BaseFragmentBinding<FragmentEditFilterBinding> {
    private EditVideoTransitionAdapter editClipAdapter;

    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
        initClip();
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
