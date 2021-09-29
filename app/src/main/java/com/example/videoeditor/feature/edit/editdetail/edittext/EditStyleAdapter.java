package com.example.videoeditor.feature.edit.editdetail.edittext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemTextStyleBinding;
import com.example.videoeditor.entities.TextStyleItem;

import java.util.List;

public class EditStyleAdapter extends RecyclerView.Adapter<EditStyleAdapter.ItemViewHolder> {
    private List<TextStyleItem> textStyles;
    private TextStyleItem selectedItem;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemTextStyleBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(textStyles.get(position));
    }

    @Override
    public int getItemCount() {
        return textStyles == null ? 0 : textStyles.size();
    }

    public void setData(List<TextStyleItem> textStyles) {
        this.textStyles = textStyles;
        notifyDataSetChanged();
    }

    class ItemViewHolder extends BaseViewHolderBinding<ItemTextStyleBinding> {

        public ItemViewHolder(ItemTextStyleBinding binding) {
            super(binding);
        }

        public void bind(TextStyleItem textStyle) {
            Glide.with(getContext()).load(textStyle.getCoverRes()).into(binding.ivCover);
            binding.viewSelected.setVisibility(textStyle == selectedItem && !textStyle.getName().equalsIgnoreCase("none")
                    ? View.VISIBLE : View.GONE);
            binding.ivCover.setOnClickListener(v -> {
                selectedItem = textStyle;
                notifyDataSetChanged();
            });
        }
    }
}
