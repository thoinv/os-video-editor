package com.example.videoeditor.feature.edit.editdetail.editduration;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemRecentSelectedBinding;
import com.example.videoeditor.entities.Media;
import com.example.videoeditor.feature.recent.RecentCacheData;

import java.util.List;

public class EditDurationAdapter extends RecyclerView.Adapter<EditDurationAdapter.ItemViewHolder> {

    private List<Media> media;
    private Media selectedItem;
    private boolean canSelectItem;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemRecentSelectedBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Media mediaItem = media.get(position);
        holder.bind(mediaItem);
    }

    @Override
    public int getItemCount() {
        return media == null ? 0 : media.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Media> media) {
        this.media = media;
        notifyDataSetChanged();
    }

    public EditDurationAdapter canSelectItem() {
        canSelectItem = true;
        return this;
    }

    class ItemViewHolder extends BaseViewHolderBinding<ItemRecentSelectedBinding> {

        public ItemViewHolder(ItemRecentSelectedBinding binding) {
            super(binding);
        }

        public void bind(Media media) {
            Glide.with(getContext()).load(media.getMediaResourceId()).into(binding.ivMedia);
            binding.btRemove.setVisibility(View.VISIBLE);
            binding.btRemove.setOnClickListener(v -> {
                RecentCacheData.instance().remove(media);
                notifyDataSetChanged();
            });

            if (canSelectItem) {
                binding.viewSelected.setVisibility(selectedItem == media ? View.VISIBLE : View.GONE);
                binding.getRoot().setOnClickListener(v -> {
                    selectedItem = media;
                    notifyDataSetChanged();
                });
            }

            binding.ivIcMediaType.setImageResource(media.getMediaTypeIconResource());
            // FIXME: 9/20/2021 change default value
            binding.tvVideoFrameTime.setText("00:02,2");
        }
    }
}
