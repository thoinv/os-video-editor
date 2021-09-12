package com.example.videoeditor.feature.recent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoeditor.base.IAdapterCallback;
import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemRecentContentBinding;
import com.example.videoeditor.entities.Media;

import java.util.LinkedList;
import java.util.List;

class RecentContentAdapter extends RecyclerView.Adapter<RecentContentAdapter.ItemViewHolder> {
    private List<Media> mediaList;
    private final List<Media> selectedItems = new LinkedList<>();
    private IAdapterCallback<Media> callback;

    public RecentContentAdapter setCallback(IAdapterCallback<Media> callback) {
        this.callback = callback;
        return this;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemRecentContentBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(mediaList.get(position), (media, position1) -> {
            if (callback != null) {
                callback.onItemClicked(media, position1);
            }
            notifyItemChanged(position);
        }, selectedItems);
    }

    public void setData(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    @Override
    public int getItemCount() {
        return mediaList == null ? 0 : mediaList.size();
    }

    public List<Media> getSelectedItems() {
        return selectedItems;
    }

    static class ItemViewHolder extends BaseViewHolderBinding<ItemRecentContentBinding> {

        public ItemViewHolder(ItemRecentContentBinding binding) {
            super(binding);
        }

        public void bind(Media media, IAdapterCallback<Media> callback, List<Media> selectedItems) {
            Glide.with(getContext()).load(media.getMediaResourceId()).into(binding.ivMedia);
            binding.ivChecked.setVisibility(selectedItems.contains(media) ? View.VISIBLE : View.GONE);
            itemView.setOnClickListener(v -> {
                if (selectedItems.contains(media)) {
                    selectedItems.remove(media);
                } else {
                    selectedItems.add(media);
                }
                if (callback != null) {
                    callback.onItemClicked(media, getAdapterPosition());
                }
            });
        }
    }

}
