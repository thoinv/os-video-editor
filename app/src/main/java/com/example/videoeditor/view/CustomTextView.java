package com.example.videoeditor.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;

import com.example.videoeditor.R;

import org.jetbrains.annotations.NotNull;

public class CustomTextView extends LinearLayoutCompat {
    private TextView tvText;
    private View viewUnderline;
    private View rootView;
    private int textColor = R.color.white;
    private int selectedTextColor = R.color.orange;
    private int textStyle = Typeface.NORMAL;
    private float textSize = 12;
    private CharSequence text;

    public CustomTextView(@NonNull @NotNull Context context) {
        super(context);
        init(context, null);
    }

    public CustomTextView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomTextView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(@NotNull Context context, @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        rootView = View.inflate(getContext(), R.layout.view_custom_text, this);
        tvText = rootView.findViewById(R.id.tv_text);
        viewUnderline = rootView.findViewById(R.id.view_underline);

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
            textColor = typedArray.getResourceId(R.styleable.CustomTextView_android_textColor, textColor);
            selectedTextColor = typedArray.getResourceId(R.styleable.CustomTextView_selectedTextColor, selectedTextColor);
            textStyle = typedArray.getInt(R.styleable.CustomTextView_android_textStyle, textStyle);
            textSize = typedArray.getDimensionPixelSize(R.styleable.CustomTextView_android_textSize, 12);
            text = typedArray.getText(R.styleable.CustomTextView_android_text);
        }

        if (!TextUtils.isEmpty(text)) {
            tvText.setText(text);
            tvText.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            tvText.setTypeface(Typeface.defaultFromStyle(textStyle));
        }

    }

    public void setText(String text) {
        tvText.setText(text);
    }

    public void setText(@StringRes int textResId) {
        tvText.setText(textResId);
    }

    public void setSelected(boolean selected) {
        int selectedColor = ContextCompat.getColor(getContext(), selectedTextColor);
        int color = ContextCompat.getColor(getContext(), textColor);

        viewUnderline.setVisibility(selected ? VISIBLE : INVISIBLE);
        tvText.setTextColor(selected ? selectedColor : color);
        viewUnderline.setBackgroundColor(selectedColor);
    }
}
