package com.example.videoeditor.feature.edit.editdetail.editfilter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemFilterGroupBinding;
import com.example.videoeditor.entities.FilterGroupItem;

import java.util.List;

public class EditFilterAdapter extends RecyclerView.Adapter<EditFilterAdapter.ItemViewHolder> {
    private List<FilterGroupItem> filterGroupItems;
    private FilterGroupItem selectedGroup;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemFilterGroupBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public int getItemCount() {
        return filterGroupItems == null ? 0 : filterGroupItems.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(filterGroupItems.get(position));
    }

    public void setData(List<FilterGroupItem> grapefruit) {
        this.filterGroupItems = grapefruit;
        notifyDataSetChanged();
    }

    class ItemViewHolder extends BaseViewHolderBinding<ItemFilterGroupBinding> {

        public ItemViewHolder(ItemFilterGroupBinding binding) {
            super(binding);
        }

        public void bind(FilterGroupItem filterGroupItem) {
            Glide.with(getContext()).load(filterGroupItem.getCover()).into(binding.ivCover);
            binding.tvName.setVisibility(filterGroupItem.isNone() ? View.GONE : View.VISIBLE);
            binding.tvName.setText(filterGroupItem.getName());
            boolean isSelected = selectedGroup == filterGroupItem && !filterGroupItem.isNone();
            binding.btMinimize.setVisibility(isSelected ? View.VISIBLE : View.GONE);
//            binding.rvFilter.setVisibility(isSelected ? View.VISIBLE : View.GONE);
            binding.getRoot().setOnClickListener(v -> {
                if (selectedGroup == filterGroupItem) {
                    selectedGroup = null;
                } else {
                    selectedGroup = filterGroupItem;
//                    FilterAdapter filterAdapter = new FilterAdapter();
//                    binding.rvFilter.setAdapter(filterAdapter);
//                    filterAdapter.setData(filterGroupItem.getFilterItems());
                }
                notifyDataSetChanged();
            });
        }
    }
}
