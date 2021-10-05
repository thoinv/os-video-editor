package com.example.videoeditor.feature.edit.editdetail.editfilter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemFilterBinding;
import com.example.videoeditor.entities.FilterItem;

import java.util.List;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ItemViewHolder> {
    private List<FilterItem> filterItems;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemFilterBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(filterItems.get(position));
    }

    @Override
    public int getItemCount() {
        return filterItems == null ? 0 : filterItems.size();
    }

    public void setData(List<FilterItem> filterItems) {
        this.filterItems = filterItems;
        notifyDataSetChanged();
    }

    class ItemViewHolder extends BaseViewHolderBinding<ItemFilterBinding> {
        public ItemViewHolder(ItemFilterBinding binding) {
            super(binding);
        }

        public void bind(FilterItem filterItem) {
            Glide.with(getContext()).load(filterItem.getCover()).into(binding.ivCover);
            binding.tvName.setText(filterItem.getName());
        }
    }
}
