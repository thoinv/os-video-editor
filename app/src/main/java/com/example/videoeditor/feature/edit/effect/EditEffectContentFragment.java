package com.example.videoeditor.feature.edit.effect;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentEditEffectContentBinding;
import com.example.videoeditor.entities.EffectItem;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class EditEffectContentFragment extends BaseFragmentBinding<FragmentEditEffectContentBinding> {

    public static EditEffectContentFragment newInstance(Map<String, List<EffectItem>> listMap) {
        EditEffectContentFragment editEffectContentFragment = new EditEffectContentFragment();
        Bundle args = new Bundle();
        args.putSerializable("data", (Serializable) listMap);
        editEffectContentFragment.setArguments(args);
        return editEffectContentFragment;
    }

    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
        Bundle arguments = getArguments();
        Map<String, List<EffectItem>> listMap = (Map<String, List<EffectItem>>) arguments.getSerializable("data");
        EditEffectAdapter effectAdapter = new EditEffectAdapter();
        binding.rvStyle.setAdapter(effectAdapter);

        EditEffectGroupAdapter effectGroupAdapter = new EditEffectGroupAdapter();
        binding.rvEffectGroup.setAdapter(effectGroupAdapter);
        effectGroupAdapter.setCallback((position, effectItems) -> {
            Log.i("superman", "initViews: 1");
            effectAdapter.setData(effectItems);
        });
        effectGroupAdapter.setData(listMap);
    }

    @Override
    protected ViewBinding binding() {
        return FragmentEditEffectContentBinding.inflate(getLayoutInflater());
    }
}
