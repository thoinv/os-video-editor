package com.example.videoeditor.feature.edit.editdetail.edittext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videoeditor.base.viewbinding.BaseViewHolderBinding;
import com.example.videoeditor.databinding.ItemFontColorBinding;
import com.example.videoeditor.entities.EditColorItem;

import java.util.List;

public class EditColorAdapter extends RecyclerView.Adapter<EditColorAdapter.ItemViewHolder> {
    private List<EditColorItem> colors;

    public interface Callback {
        void onItemChoose(EditColorItem editColorItem);
    }

    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public EditColorAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EditColorAdapter.ItemViewHolder(ItemFontColorBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull EditColorAdapter.ItemViewHolder holder, int position) {
        holder.bind(colors.get(position));
    }

    @Override
    public int getItemCount() {
        return colors == null ? 0 : colors.size();
    }

    public void setData(List<EditColorItem> colors) {
        this.colors = colors;
        notifyDataSetChanged();
    }

    class ItemViewHolder extends BaseViewHolderBinding<ItemFontColorBinding> {

        public ItemViewHolder(ItemFontColorBinding binding) {
            super(binding);
        }

        public void bind(EditColorItem editColorItem) {
            binding.ivImage.setCircleBackgroundColorResource(editColorItem.getColor());
            int colorBorder = editColorItem.getColorBorder();
            if (colorBorder > 0) {
                binding.ivImage.setBorderColor(colorBorder);
            }
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null) {
                        callback.onItemChoose(editColorItem);
                    }
                }
            });
        }
    }
}
