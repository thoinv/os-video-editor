package com.example.videoeditor.feature.edit.editdetail.editsticker;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemEffectGroupBinding;
import com.example.videoeditor.databinding.ItemStickerGroupBinding;
import com.example.videoeditor.entities.StickerItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EditStickerGroupAdapter extends RecyclerView.Adapter<EditStickerGroupAdapter.ItemStickerGroupHolder> {

    private ArrayList<String> groups;
    private Map<String, List<StickerItem>> groupMap;
    private Callback callback;
    private String selectedGroup;

    public interface Callback {
        void onItemSelected(int position, List<StickerItem> effectItems);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @NonNull
    @NotNull
    @Override
    public EditStickerGroupAdapter.ItemStickerGroupHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ItemStickerGroupHolder(ItemStickerGroupBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EditStickerGroupAdapter.ItemStickerGroupHolder holder, int position) {
        String groupName = groups.get(position);
        holder.bind(groupName, callback);
    }

    @Override
    public int getItemCount() {
        return groups == null ? 0 : groups.size();
    }

    public void setData(Map<String, List<StickerItem>> groupMap) {
        this.selectedGroup = new ArrayList<>(groupMap.keySet()).get(0);
        updateData(groupMap);
        if (callback != null) {
            callback.onItemSelected(0, groupMap.get(selectedGroup));
        }
    }

    private void updateData(Map<String, List<StickerItem>> groupMap) {
        this.groups = new ArrayList<>(groupMap.keySet());
        this.groupMap = groupMap;
        notifyDataSetChanged();
    }

    class ItemStickerGroupHolder extends BaseViewHolderBinding<ItemStickerGroupBinding> {
        public ItemStickerGroupHolder(ItemStickerGroupBinding binding) {
            super(binding);
        }

        public void bind(String group, Callback callback) {
            binding.tvGroupName.setText(group);
            binding.tvGroupName.setSelected(group.equals(selectedGroup));
            itemView.setOnClickListener(v -> {
                if (callback != null) {
                    callback.onItemSelected(getAdapterPosition(), groupMap.get(group));
                }
                selectedGroup = group;
                notifyDataSetChanged();
            });
        }
    }
}
