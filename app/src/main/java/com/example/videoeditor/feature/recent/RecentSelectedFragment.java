package com.example.videoeditor.feature.recent;

import android.os.Bundle;
import android.widget.Toast;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentRecentSelectedItemBinding;

public class RecentSelectedFragment extends BaseFragmentBinding<FragmentRecentSelectedItemBinding> {

    @Override
    protected void bindViewClickEvent() {
        binding.btContinue.setOnClickListener(v -> onContinueButtonClicked());
        binding.btShowMore.setOnClickListener(v -> onShowMoreButtonClicked());
    }

    private void onShowMoreButtonClicked() {

    }

    private void onContinueButtonClicked() {
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        RecentCacheData.instance().getSelectedItemsObservable(getContext(), media -> {
            binding.btContinue.setText(String.format(context.getString(R.string.recent_continue), media.size()));
        });

    }

    @Override
    protected ViewBinding binding() {
        return FragmentRecentSelectedItemBinding.inflate(getLayoutInflater());
    }
}
