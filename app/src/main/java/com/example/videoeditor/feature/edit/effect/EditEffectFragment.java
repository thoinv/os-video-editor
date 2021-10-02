package com.example.videoeditor.feature.edit.effect;

import android.media.effect.Effect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentEditEffectBinding;
import com.example.videoeditor.entities.EffectItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditEffectFragment extends BaseFragmentBinding<FragmentEditEffectBinding> {
    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
        initTabs();
        initEffectGroups();
    }

    private void initEffectGroups() {
        Map<String, List<EffectItem>> stringEffectItemMap = new HashMap<>();
        List<EffectItem> effectItems = Arrays.asList(
                EffectItem.createItem(1, "D0-2", R.drawable.effect_ic_1),
                EffectItem.createItem(2, "D0-3", R.drawable.effect_ic_1),
                EffectItem.createItem(3, "D0-4", R.drawable.effect_ic_1),
                EffectItem.createItem(4, "D0-5", R.drawable.effect_ic_1),
                EffectItem.createItem(5, "D0-6", R.drawable.effect_ic_1));
        stringEffectItemMap.put("None", effectItems);
        List<EffectItem> leafItems = Arrays.asList(
                EffectItem.createItem(1, "Leaf", R.drawable.effect_ic_1),
                EffectItem.createItem(2, "Star", R.drawable.effect_ic_1),
                EffectItem.createItem(4, "Sparkling", R.drawable.effect_ic_1));
        stringEffectItemMap.put("Leaf", leafItems);
        List<EffectItem> starItems = Arrays.asList(
                EffectItem.createItem(1, "Koko 1", R.drawable.effect_ic_1),
                EffectItem.createItem(2, "Koko 2", R.drawable.effect_ic_1),
                EffectItem.createItem(3, "Koko 3", R.drawable.effect_ic_1),
                EffectItem.createItem(4, "Koko 4", R.drawable.effect_ic_1));
        stringEffectItemMap.put("Koko", starItems);

        List<EffectItem> kylieList = Arrays.asList(
                EffectItem.createItem(1, "Kylie 1", R.drawable.effect_ic_1),
                EffectItem.createItem(2, "Kylie 2", R.drawable.effect_ic_1),
                EffectItem.createItem(4, "Kylie 4", R.drawable.effect_ic_1));
        stringEffectItemMap.put("Kylie", kylieList);


        EffectGroupAdapter effectGroupAdapter = new EffectGroupAdapter();
        binding.rvEffectGroup.setAdapter(effectGroupAdapter);
        effectGroupAdapter.setData(stringEffectItemMap);
        effectGroupAdapter.setCallback(new EffectGroupAdapter.Callback() {
            @Override
            public void onItemSelected(int position, List<EffectItem> effectItems) {
                Toast.makeText(getContext(), String.valueOf(effectItems.size()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initTabs() {
        binding.tabFilter.setSelected(true);
        View.OnClickListener onClickListener = v -> {
            int id = v.getId();
            if (id == R.id.tab_effect) {
                binding.tabEffect.setSelected(true);
                binding.tabFilter.setSelected(false);
            } else if (id == R.id.tab_filter) {
                binding.tabEffect.setSelected(false);
                binding.tabFilter.setSelected(true);
            }
        };
        binding.tabFilter.setOnClickListener(onClickListener);
        binding.tabEffect.setOnClickListener(onClickListener);
    }

    @Override
    protected ViewBinding binding() {
        return FragmentEditEffectBinding.inflate(getLayoutInflater());
    }
}
