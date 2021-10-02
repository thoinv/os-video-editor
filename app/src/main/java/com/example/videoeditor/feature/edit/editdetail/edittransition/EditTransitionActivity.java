package com.example.videoeditor.feature.edit.editdetail.edittransition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityEditTransitionBinding;
import com.example.videoeditor.entities.TransitionItem;
import com.example.videoeditor.util.SpacesItemDecoration;
import com.example.videoeditor.util.Util;

import java.util.Arrays;
import java.util.List;

public class EditTransitionActivity extends BaseActivityBinding<ActivityEditTransitionBinding> {
    public static void open(Context context) {
        context.startActivity(new Intent(context, EditTransitionActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        binding.layoutToolbar.btCancel.setOnClickListener(v -> finish());
        binding.layoutToolbar.btSave.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected ViewBinding binding() {
        return ActivityEditTransitionBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {
        List<TransitionItem> transitionItems = Arrays.asList(
                TransitionItem.createNone(),
                TransitionItem.createItem(1, R.drawable.transition_ic_1, "Fade"),
                TransitionItem.createItem(2, R.drawable.transition_ic_1, "Black"),
                TransitionItem.createItem(3, R.drawable.transition_ic_1, "White")
        );
        EditTransitionAdapter adapter = new EditTransitionAdapter();
        binding.rvTrans.setAdapter(adapter);
        binding.rvTrans.addItemDecoration(new SpacesItemDecoration(Util.dimenToPixel(this, R.dimen.px12)));
        adapter.setData(transitionItems);
    }
}
