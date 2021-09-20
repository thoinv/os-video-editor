package com.example.videoeditor.feature.recent.selected;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentRecentSelectedItemBinding;
import com.example.videoeditor.feature.edit.EditActivity;
import com.example.videoeditor.feature.recent.RecentCacheData;
import com.example.videoeditor.util.GridSpacingItemDecoration;
import com.example.videoeditor.util.Util;

public class RecentSelectedFragment extends BaseFragmentBinding<FragmentRecentSelectedItemBinding> {

    @Override
    protected void bindViewClickEvent() {
        binding.btContinue.setOnClickListener(v -> onContinueButtonClicked());
        binding.btShowMore.setOnClickListener(v -> onShowMoreButtonClicked());
    }

    private void onShowMoreButtonClicked() {

    }

    private void onContinueButtonClicked() {
        EditActivity.open(getContext());
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        binding.rvSelectFiles.setLayoutManager(new GridLayoutManager(getContext(), 4));
        RecentSelectedAdapter recentSelectedAdapter = new RecentSelectedAdapter();
        binding.rvSelectFiles.setAdapter(recentSelectedAdapter);
        binding.rvSelectFiles.addItemDecoration(new GridSpacingItemDecoration(4, Util.dimenToPixel(context, R.dimen.px12), false));

        RecentCacheData.instance().getSelectedItemsObservable(getContext(), media -> {
            binding.btContinue.setText(String.format(context.getString(R.string.recent_continue), media.size()));
            recentSelectedAdapter.setData(media);
        });

    }

    @Override
    protected ViewBinding binding() {
        return FragmentRecentSelectedItemBinding.inflate(getLayoutInflater());
    }
}
