package com.example.videoeditor.feature.recent.selected;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemRecentSelectedBinding;
import com.example.videoeditor.entities.Media;
import com.example.videoeditor.feature.recent.RecentCacheData;

import java.util.List;

public class RecentSelectedAdapter extends RecyclerView.Adapter<RecentSelectedAdapter.ItemViewHolder> {

    private List<Media> media;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemRecentSelectedBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Media mediaItem = media.get(position);
        holder.bind(mediaItem, new ItemViewHolder.Delegate() {
            @Override
            public void removeItem() {
                RecentCacheData.instance().remove(mediaItem);
                notifyDataSetChanged();
            }
        });
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

    static class ItemViewHolder extends BaseViewHolderBinding<ItemRecentSelectedBinding> {
        public interface Delegate {
            void removeItem();
        }

        public ItemViewHolder(ItemRecentSelectedBinding binding) {
            super(binding);
        }

        public void bind(Media media, Delegate delegate) {
            Glide.with(getContext()).load(media.getMediaResourceId()).into(binding.ivMedia);
            binding.btRemove.setOnClickListener(v -> {
                if (delegate != null) {
                    delegate.removeItem();
                }
            });

        }
    }
}
