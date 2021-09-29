package com.example.videoeditor.feature.edit.editdetail.edittext;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.R;
import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentTextCustomBinding;
import com.example.videoeditor.entities.TextAlign;
import com.example.videoeditor.entities.TextStyle;

import java.util.HashMap;
import java.util.Map;

public class EditTextCustomFragment extends BaseFragmentBinding<FragmentTextCustomBinding> {

    private int opacity;
    private int outline;
    private int spacing;

    private TextAlign textAlign = TextAlign.CENTER;
    private TextStyle textStyle = TextStyle.BOLD;
    private final Map<Integer, TextAlign> textAlignMap = new HashMap<>();
    private final Map<Integer, TextStyle> textStyleMap = new HashMap<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textAlignMap.put(R.id.bt_align_center, TextAlign.CENTER);
        textAlignMap.put(R.id.bt_align_left, TextAlign.LEFT);
        textAlignMap.put(R.id.bt_align_right, TextAlign.RIGHT);

        textStyleMap.put(R.id.bt_italic, TextStyle.ITALIC);
        textStyleMap.put(R.id.bt_bold, TextStyle.BOLD);
        textStyleMap.put(R.id.bt_underline, TextStyle.UNDERLINE);
    }

    @Override
    protected void bindViewClickEvent() {
        initTextStyle();
        initTextAlign();
    }

    private void initTextAlign() {
        binding.btAlignCenter.setOnClickListener(v -> {
            textAlign = TextAlign.CENTER;
        });
        binding.btAlignLeft.setOnClickListener(v -> {
            textAlign = TextAlign.LEFT;
        });
        binding.btAlignRight.setOnClickListener(v -> {
            textAlign = TextAlign.RIGHT;
        });
    }

    private void initTextStyle() {
        binding.btBold.setOnClickListener(v -> {
            textStyle = TextStyle.BOLD;
        });
        binding.btItalic.setOnClickListener(v -> {
            textStyle = TextStyle.ITALIC;
        });
        binding.btUnderline.setOnClickListener(v -> {
            textStyle = TextStyle.UNDERLINE;
        });
    }

    @Override
    protected void initViews(Bundle bundle) {
        SeekBar.OnSeekBarChangeListener barChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView textView = null;
                int id = seekBar.getId();
                if (id == R.id.sb_opacity) {
                    opacity = progress;
                    textView = binding.tvOpacityPercent;
                } else if (id == R.id.sb_outline) {
                    outline = progress;
                    textView = binding.tvOutlinePercent;
                } else if (id == R.id.sb_spacing) {
                    spacing = progress;
                    textView = binding.tvSpacingPercent;
                }
                if (textView != null) {
                    textView.setText(String.format("%d%%", progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        binding.sbOpacity.setOnSeekBarChangeListener(barChangeListener);
        binding.sbOutline.setOnSeekBarChangeListener(barChangeListener);
        binding.sbSpacing.setOnSeekBarChangeListener(barChangeListener);
    }

    public int getOpacity() {
        return opacity;
    }

    public int getOutline() {
        return outline;
    }

    public int getSpacing() {
        return spacing;
    }

    public TextAlign getTextAlign() {
        return textAlign;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    @Override
    protected ViewBinding binding() {
        return FragmentTextCustomBinding.inflate(getLayoutInflater());
    }
}
