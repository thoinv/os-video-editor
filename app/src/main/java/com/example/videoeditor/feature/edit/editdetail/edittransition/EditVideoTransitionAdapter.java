package com.example.videoeditor.feature.edit.editdetail.edittransition;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemVideoTransitionBinding;
import com.example.videoeditor.entities.Media;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EditVideoTransitionAdapter extends RecyclerView.Adapter<EditVideoTransitionAdapter.ItemViewHolder> {

    private List<Media> medias;
    private Media selectedItem;

    public Media getSelectedItem() {
        return selectedItem;
    }

    public List<Media> getMediaItems() {
        return medias;
    }

    public interface Callback {
        void onItemSelected(int position, Media media);
    }

    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @NonNull
    @NotNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(ItemVideoTransitionBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EditVideoTransitionAdapter.ItemViewHolder holder, int position) {
        holder.bind(medias.get(position));
    }

    @Override
    public int getItemCount() {
        return medias == null ? 0 : medias.size();
    }

    public void setData(List<Media> selectedItems) {
        this.medias = selectedItems;
    }

    class ItemViewHolder extends BaseViewHolderBinding<ItemVideoTransitionBinding> {

        public ItemViewHolder(ItemVideoTransitionBinding binding) {
            super(binding);
        }

        public void bind(Media media) {
            int adapterPosition = getAdapterPosition();
            binding.btAddTransition.setVisibility(adapterPosition == 0 ? View.GONE : View.VISIBLE);
            binding.btAddTransition.setImageResource(media == selectedItem ?
                    R.drawable.all_vector_transition_active : R.drawable.all_vector_transition_normal);
            binding.btAddTransition.setOnClickListener(v -> {
                if (callback != null) {
                    callback.onItemSelected(adapterPosition, media);
                }
                selectedItem = media;
                notifyDataSetChanged();
            });
            Glide.with(getContext()).load(media.getMediaResourceId()).into(binding.layoutMediaContent.ivMedia);
            binding.layoutMediaContent.ivIcMediaType.setImageResource(media.getMediaTypeIconResource());
        }
    }
}
