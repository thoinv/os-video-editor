package com.example.videoeditor.feature.edit.editdetail.edittransition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.text.HtmlCompat;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityEditTransitionBinding;
import com.example.videoeditor.entities.Media;
import com.example.videoeditor.entities.TransitionItem;
import com.example.videoeditor.feature.recent.RecentCacheData;
import com.example.videoeditor.util.SpacesItemDecoration;
import com.example.videoeditor.util.Util;

import java.util.Arrays;
import java.util.List;

public class EditTransitionActivity extends BaseActivityBinding<ActivityEditTransitionBinding> {
    private EditVideoTransitionAdapter editClipAdapter;

    public static void open(Context context) {
        context.startActivity(new Intent(context, EditTransitionActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        binding.layoutToolbar.btCancel.setOnClickListener(v -> finish());
        binding.layoutToolbar.btSave.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected ViewBinding binding() {
        return ActivityEditTransitionBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {
        initClip();
        initTransition();
    }

    private void initClip() {
        List<Media> selectedItems = RecentCacheData.instance().getSelectedItems();
        String source = String.format(getString(R.string.clip_number_format), selectedItems.size());
        binding.tvNumberOfMedia.setText(HtmlCompat.fromHtml(source, HtmlCompat.FROM_HTML_MODE_LEGACY));
        editClipAdapter = new EditVideoTransitionAdapter();
        binding.rvClips.setAdapter(editClipAdapter);
        editClipAdapter.setData(selectedItems);
        binding.rvClips.addItemDecoration(new SpacesItemDecoration(Util.dimenToPixel(this, R.dimen.px4)));
    }

    private void initTransition() {
        List<TransitionItem> transitionItems = Arrays.asList(
                TransitionItem.createNone(),
                TransitionItem.createItem(1, R.drawable.transition_ic_1, "Fade"),
                TransitionItem.createItem(2, R.drawable.transition_ic_1, "Black"),
                TransitionItem.createItem(3, R.drawable.transition_ic_1, "White"),
                TransitionItem.createItem(4, R.drawable.transition_ic_1, "White 1"),
                TransitionItem.createItem(5, R.drawable.transition_ic_1, "White 2"),
                TransitionItem.createItem(6, R.drawable.transition_ic_1, "White 3")
        );
        EditTransitionAdapter adapter = new EditTransitionAdapter();
        adapter.setCallback(new EditTransitionAdapter.Callback() {
            @Override
            public void onItemClicked(int position, TransitionItem transitionItem) {
                editClipAdapter.getSelectedItem().setTransitionItem(transitionItem);
            }
        });
        binding.rvTrans.setAdapter(adapter);
        binding.rvTrans.addItemDecoration(new SpacesItemDecoration(Util.dimenToPixel(this, R.dimen.px12)));
        adapter.setData(transitionItems);
    }
}
