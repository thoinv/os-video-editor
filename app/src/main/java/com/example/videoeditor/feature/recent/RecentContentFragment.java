package com.example.videoeditor.feature.recent;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.IAdapterCallback;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentRecentContentBinding;
import com.example.videoeditor.entities.Media;

import java.util.Arrays;
import java.util.List;

public class RecentContentFragment extends BaseFragmentBinding<FragmentRecentContentBinding> {
    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
        binding.rvMedia.setLayoutManager(new GridLayoutManager(getContext(), 4));
        RecentContentAdapter recentContentAdapter = new RecentContentAdapter()
                .setCallback(new IAdapterCallback<Media>() {
                    @Override
                    public void onItemClicked(Media media, int position) {
                        Toast.makeText(getContext(), "Select item " + position, Toast.LENGTH_SHORT).show();
                    }
                });
        binding.rvMedia.setAdapter(recentContentAdapter);
        List<Media> mediaList = Arrays.asList(
                Media.createObject(R.drawable.ic_fx),
                Media.createObject(R.drawable.ic_effect),
                Media.createObject(R.drawable.ic_sticker),
                Media.createObject(R.drawable.ic_text)
        );
        recentContentAdapter.setData(mediaList);
    }

    @Override
    protected ViewBinding binding() {
        return FragmentRecentContentBinding.inflate(getLayoutInflater());
    }
}
