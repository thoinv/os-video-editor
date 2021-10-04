package com.example.videoeditor.feature.edit.theme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemThemeBinding;
import com.example.videoeditor.entities.ThemeItem;

import java.util.List;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ItemViewHolder> {

    private List<ThemeItem> items;
    private ThemeItem selectedItem;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemThemeBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public void setData(List<ThemeItem> data) {
        this.items = data;
        notifyDataSetChanged();
    }

    public ThemeItem getSelectedItem() {
        return selectedItem;
    }

    class ItemViewHolder extends BaseViewHolderBinding<ItemThemeBinding> {

        public ItemViewHolder(ItemThemeBinding binding) {
            super(binding);
        }

        public void bind(ThemeItem themeItem) {
            Glide.with(getContext()).load(themeItem.getCover()).into(binding.ivThemeCover);
            binding.tvThemeName.setText(themeItem.getName());
            binding.viewSelected.setVisibility(selectedItem == themeItem ? View.VISIBLE : View.GONE);
            binding.getRoot().setOnClickListener(v -> {
                selectedItem = themeItem;
                notifyDataSetChanged();
            });
        }
    }
}
