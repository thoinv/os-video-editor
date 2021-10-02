package com.example.videoeditor.feature.edit.effect;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentEditEffectBinding;
import com.example.videoeditor.entities.EffectItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditEffectFragment extends BaseFragmentBinding<FragmentEditEffectBinding> {
    private Fragment currentFragment;
    private Fragment prevFragment;
    private EditEffectContentFragment effectFragment;
    private EditEffectContentFragment filterFragment;

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

        Map<String, List<EffectItem>> stringFilterItemMap = new HashMap<>();
        List<EffectItem> filters_1 = Arrays.asList(
                EffectItem.createItem(1, "FD0-2", R.drawable.effect_ic_1),
                EffectItem.createItem(2, "FD0-3", R.drawable.effect_ic_1),
                EffectItem.createItem(3, "FD0-4", R.drawable.effect_ic_1),
                EffectItem.createItem(4, "FD0-5", R.drawable.effect_ic_1),
                EffectItem.createItem(5, "FD0-6", R.drawable.effect_ic_1));
        stringFilterItemMap.put("None", filters_1);
        List<EffectItem> filters_2 = Arrays.asList(
                EffectItem.createItem(1, "FLeaf", R.drawable.effect_ic_1),
                EffectItem.createItem(2, "FStar", R.drawable.effect_ic_1),
                EffectItem.createItem(4, "FSparkling", R.drawable.effect_ic_1));
        stringFilterItemMap.put("FLeaf", filters_2);
        List<EffectItem> filters_3 = Arrays.asList(
                EffectItem.createItem(1, "FKoko 1", R.drawable.effect_ic_1),
                EffectItem.createItem(2, "FKoko 2", R.drawable.effect_ic_1),
                EffectItem.createItem(3, "FKoko 3", R.drawable.effect_ic_1),
                EffectItem.createItem(4, "FKoko 4", R.drawable.effect_ic_1));
        stringFilterItemMap.put("FKoko", filters_3);

        List<EffectItem> filters_4 = Arrays.asList(
                EffectItem.createItem(1, "FKylie 1", R.drawable.effect_ic_1),
                EffectItem.createItem(2, "FKylie 2", R.drawable.effect_ic_1),
                EffectItem.createItem(4, "FKylie 4", R.drawable.effect_ic_1));
        stringFilterItemMap.put("FKylie", filters_4);

        initFragment(stringEffectItemMap, stringFilterItemMap);
    }

    private void initFragment(Map<String, List<EffectItem>> stringEffectItemMap, Map<String, List<EffectItem>> stringFilterItemMap) {
        effectFragment = EditEffectContentFragment.newInstance(stringEffectItemMap);
        filterFragment = EditEffectContentFragment.newInstance(stringFilterItemMap);
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, filterFragment)
                .add(R.id.container, effectFragment)
                .show(filterFragment)
                .hide(effectFragment)
                .commitAllowingStateLoss();
    }

    public void showFragment(Fragment fragment) {
        prevFragment = currentFragment;
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        if (prevFragment != null) {
            fragmentTransaction.hide(prevFragment);
        }
        fragmentTransaction.show(fragment).commitAllowingStateLoss();
        currentFragment = fragment;
    }

    private void initTabs() {
        binding.tabFilter.setSelected(true);
        View.OnClickListener onClickListener = v -> {
            int id = v.getId();
            if (id == R.id.tab_effect) {
                binding.tabEffect.setSelected(true);
                binding.tabFilter.setSelected(false);
                showFragment(effectFragment);
            } else if (id == R.id.tab_filter) {
                binding.tabEffect.setSelected(false);
                binding.tabFilter.setSelected(true);
                showFragment(filterFragment);
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
