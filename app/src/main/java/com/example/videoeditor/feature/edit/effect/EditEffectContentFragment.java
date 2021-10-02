package com.example.videoeditor.feature.edit.effect;

import android.os.Bundle;
import android.util.Log;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentEditEffectContentBinding;
import com.example.videoeditor.entities.EffectItem;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class EditEffectContentFragment extends BaseFragmentBinding<FragmentEditEffectContentBinding> {

    private static final String EXTRA_DATA = "data";

    public static EditEffectContentFragment newInstance(Map<String, List<EffectItem>> listMap) {
        EditEffectContentFragment editEffectContentFragment = new EditEffectContentFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATA, (Serializable) listMap);
        editEffectContentFragment.setArguments(args);
        return editEffectContentFragment;
    }

    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
        Bundle arguments = getArguments();
        Map<String, List<EffectItem>> listMap = (Map<String, List<EffectItem>>) arguments.getSerializable(EXTRA_DATA);
        EditEffectAdapter effectAdapter = new EditEffectAdapter();
        binding.rvStyle.setAdapter(effectAdapter);

        EditEffectGroupAdapter effectGroupAdapter = new EditEffectGroupAdapter();
        binding.rvEffectGroup.setAdapter(effectGroupAdapter);
        effectGroupAdapter.setCallback((position, effectItems) -> {
            effectAdapter.setData(effectItems);
        });
        effectGroupAdapter.setData(listMap);
    }

    @Override
    protected ViewBinding binding() {
        return FragmentEditEffectContentBinding.inflate(getLayoutInflater());
    }
}
