package com.example.videoeditor.feature.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoeditor.base.IAdapterCallback;
import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemNewThemeBinding;
import com.example.videoeditor.entities.NewTheme;

import java.util.List;

public class NewThemeAdapter extends RecyclerView.Adapter<NewThemeAdapter.ThemeItemViewHolder> {
    private List<NewTheme> newThemes;
    private IAdapterCallback<NewTheme> callback;

    public NewThemeAdapter setCallback(IAdapterCallback<NewTheme> callback) {
        this.callback = callback;
        return this;
    }

    public NewThemeAdapter(List<NewTheme> newThemes) {
        this.newThemes = newThemes;
    }

    @NonNull
    @Override
    public ThemeItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ThemeItemViewHolder(ItemNewThemeBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeItemViewHolder holder, int position) {
        holder.bind(newThemes.get(position), callback);
    }

    @Override
    public int getItemCount() {
        return newThemes == null ? 0 : newThemes.size();
    }

    static class ThemeItemViewHolder extends BaseViewHolderBinding<ItemNewThemeBinding> {
        public ThemeItemViewHolder(ItemNewThemeBinding binding) {
            super(binding);
        }

        public void bind(NewTheme newTheme, IAdapterCallback<NewTheme> callback) {
            itemView.setOnClickListener(v -> {
                if (callback != null) {
                    callback.onItemClicked(newTheme, getAdapterPosition());
                }
            });
            Glide.with(getContext()).load(newTheme.getCover()).into(binding.ivCover);
            binding.ivThemeSmallIcon.setImageResource(newTheme.getIcon());
            binding.tvThemeName.setText(newTheme.getName());
        }
    }

}
