package com.example.videoeditor.feature.edit.editdetail.editsticker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemStickerBinding;
import com.example.videoeditor.entities.StickerItem;

import java.util.List;

public class EditStickerAdapter extends RecyclerView.Adapter<EditStickerAdapter.ItemViewHolder> {

    private List<StickerItem> items;
    private StickerItem selectedItem;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemStickerBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public void setData(List<StickerItem> data) {
        this.items = data;
        notifyDataSetChanged();
    }

    public StickerItem getSelectedItem() {
        return selectedItem;
    }

    class ItemViewHolder extends BaseViewHolderBinding<ItemStickerBinding> {

        public ItemViewHolder(ItemStickerBinding binding) {
            super(binding);
        }

        public void bind(StickerItem stickerItem) {
            Glide.with(getContext()).load(stickerItem.getCover()).into(binding.ivSticker);
            binding.viewSelected.setVisibility(selectedItem == stickerItem ? View.VISIBLE : View.GONE);
            binding.getRoot().setOnClickListener(v -> {
                selectedItem = stickerItem;
                notifyDataSetChanged();
            });
        }
    }
}
