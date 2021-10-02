package com.example.videoeditor.feature.edit.effect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemEditEffectBinding;
import com.example.videoeditor.databinding.ItemTextStyleBinding;
import com.example.videoeditor.entities.EffectItem;
import com.example.videoeditor.entities.TextStyleItem;

import java.util.List;

public class EditEffectAdapter extends RecyclerView.Adapter<EditEffectAdapter.ItemViewHolder> {
    private List<EffectItem> effectItems;
    private EffectItem selectedItem;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemEditEffectBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(effectItems.get(position));
    }

    @Override
    public int getItemCount() {
        return effectItems == null ? 0 : effectItems.size();
    }

    public void setData(List<EffectItem> effectItems) {
        this.effectItems = effectItems;
        notifyDataSetChanged();
    }

    class ItemViewHolder extends BaseViewHolderBinding<ItemEditEffectBinding> {

        public ItemViewHolder(ItemEditEffectBinding binding) {
            super(binding);
        }

        public void bind(EffectItem effectItem) {
            Glide.with(getContext()).load(effectItem.getCover()).into(binding.ivCover);
            binding.tvName.setText(effectItem.getName());
            binding.viewSelected.setVisibility(effectItem == selectedItem && !effectItem.getName().equalsIgnoreCase("none")
                    ? View.VISIBLE : View.GONE);
            binding.ivCover.setOnClickListener(v -> {
                selectedItem = effectItem;
                notifyDataSetChanged();
            });
        }
    }
}
