package com.example.videoeditor.feature.edit.editdetail.edittransition;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemTransitionBinding;
import com.example.videoeditor.entities.TransitionItem;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EditTransitionAdapter extends RecyclerView.Adapter<EditTransitionAdapter.ItemViewHolder> {
    private List<TransitionItem> transitionItems;
    private Callback callback;
    private TransitionItem selectedItem;

    public interface Callback {
        void onItemClicked(int position, TransitionItem transitionItem);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public TransitionItem getSelectedItem() {
        return selectedItem;
    }

    @NonNull
    @NotNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemTransitionBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemViewHolder holder, int position) {
        holder.bind(transitionItems.get(position), callback);
    }

    @Override
    public int getItemCount() {
        return transitionItems == null ? 0 : transitionItems.size();
    }

    public void setData(List<TransitionItem> transitionItems) {
        this.transitionItems = transitionItems;
        notifyDataSetChanged();
    }

    class ItemViewHolder extends BaseViewHolderBinding<ItemTransitionBinding> {
        public ItemViewHolder(ItemTransitionBinding binding) {
            super(binding);
        }

        public void bind(TransitionItem transitionItem, Callback callback) {
            Glide.with(getContext()).load(transitionItem.getCover()).into(binding.ivCover);
            boolean selected = transitionItem == selectedItem && !selectedItem.isNone();
            binding.viewSelected.setVisibility(selected ? View.VISIBLE : View.GONE);
            binding.tvName.setText(transitionItem.getName());
            binding.getRoot().setOnClickListener(v -> {
                if (callback != null) {
                    callback.onItemClicked(getAdapterPosition(), transitionItem);
                }
                selectedItem = transitionItem;
                notifyDataSetChanged();
            });
        }
    }

}
