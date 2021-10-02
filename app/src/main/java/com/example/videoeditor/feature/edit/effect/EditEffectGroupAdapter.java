package com.example.videoeditor.feature.edit.effect;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemEffectGroupBinding;
import com.example.videoeditor.entities.EffectItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EditEffectGroupAdapter extends RecyclerView.Adapter<EditEffectGroupAdapter.ItemEffectGroupHolder> {

    private ArrayList<String> groups;
    private Map<String, List<EffectItem>> groupMap;
    private Callback callback;
    private String selectedGroup;

    public interface Callback {
        void onItemSelected(int position, List<EffectItem> effectItems);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @NonNull
    @NotNull
    @Override
    public ItemEffectGroupHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ItemEffectGroupHolder(ItemEffectGroupBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemEffectGroupHolder holder, int position) {
        String groupName = groups.get(position);
        holder.bind(groupName, callback);
    }

    @Override
    public int getItemCount() {
        return groups == null ? 0 : groups.size();
    }

    public void setData(Map<String, List<EffectItem>> groupMap) {
        this.selectedGroup = new ArrayList<>(groupMap.keySet()).get(0);
        updateData(groupMap);
        Log.i("superman", "setData: 1");
        if (callback != null) {
            Log.i("superman", "setData: 2");
            callback.onItemSelected(0, groupMap.get(selectedGroup));
        }
    }

    private void updateData(Map<String, List<EffectItem>> groupMap) {
        this.groups = new ArrayList<>(groupMap.keySet());
        this.groupMap = groupMap;
        notifyDataSetChanged();
    }

    class ItemEffectGroupHolder extends BaseViewHolderBinding<ItemEffectGroupBinding> {
        public ItemEffectGroupHolder(ItemEffectGroupBinding binding) {
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
