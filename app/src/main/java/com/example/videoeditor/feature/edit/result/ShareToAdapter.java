package com.example.videoeditor.feature.edit.result;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemShareBinding;

import java.util.List;

public class ShareToAdapter extends RecyclerView.Adapter<ShareToAdapter.ItemViewHolder> {

    private List<ShareItem> shareItems;
    private Callback callback;

    protected interface Callback {
        void onItemClicked(ShareItem shareItem);
    }

    public ShareToAdapter setCallback(Callback callback) {
        this.callback = callback;
        return this;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemShareBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(shareItems.get(position), callback);
    }

    @Override
    public int getItemCount() {
        return this.shareItems == null ? 0 : this.shareItems.size();
    }

    public void setData(List<ShareItem> shareItems) {
        this.shareItems = shareItems;
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends BaseViewHolderBinding<ItemShareBinding> {
        public ItemViewHolder(ItemShareBinding binding) {
            super(binding);
        }

        public void bind(ShareItem shareItem, Callback callback) {
            binding.ivType.setImageResource(shareItem.getIconResId());
            binding.tvTypeName.setText(shareItem.getStringResId());
            itemView.setOnClickListener(v -> {
                if (callback != null) {
                    callback.onItemClicked(shareItem);
                }
            });
        }
    }
}
