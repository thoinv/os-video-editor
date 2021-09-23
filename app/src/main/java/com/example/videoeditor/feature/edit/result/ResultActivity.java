package com.example.videoeditor.feature.edit.result;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.example.videoeditor.databinding.ActivityResultBinding;

import java.util.Arrays;
import java.util.List;

public class ResultActivity extends BaseActivityBinding<ActivityResultBinding> {
    public static void open(Context context) {
        context.startActivity(new Intent(context, ResultActivity.class));
    }

    @Override
    protected void bindViewClickEvent() {
        binding.layoutToolbar.btToolbarBack.setOnClickListener(v -> finish());
    }

    @Override
    protected ViewBinding binding() {
        return ActivityResultBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {
        binding.layoutToolbar.tvToolbarTitle.setText(R.string.share);
        ShareToAdapter shareToAdapter = new ShareToAdapter()
                .setCallback(shareItem -> {
                    Toast.makeText(this, shareItem.getStringResId(), Toast.LENGTH_SHORT).show();
                });
        binding.rvShare.setAdapter(shareToAdapter);

        List<ShareItem> shareItems = Arrays.asList(
                ShareItem.create(R.drawable.share_vector_whats_app, R.string.share_whats_app),
                ShareItem.create(R.drawable.share_vector_messager, R.string.share_messager),
                ShareItem.create(R.drawable.share_vector_youtube, R.string.share_youtube),
                ShareItem.create(R.drawable.share_vector_instagram, R.string.share_instagram),
                ShareItem.create(R.drawable.share_vector_facebook, R.string.share_facebook),
                ShareItem.create(R.drawable.share_vector_email, R.string.share_email),
                ShareItem.create(R.drawable.share_ic_line, R.string.share_line),
                ShareItem.create(R.drawable.share_vector_more, R.string.share_more)
        );
        shareToAdapter.setData(shareItems);
    }
}
