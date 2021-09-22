package com.example.videoeditor.view;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import java.text.DecimalFormat;

public class AnimationTextView extends AppCompatTextView {

    private boolean isAnimating = false;
    private ValueAnimator mCountAnimator;
    private CountAnimationListener mCountAnimationListener;

    private DecimalFormat mDecimalFormat;

    private static final long DEFAULT_DURATION = 1000;
    private String sFormat;

    public AnimationTextView(Context context) {
        this(context, null, 0);
    }

    public AnimationTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimationTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpAnimator();
    }

    public AnimationTextView setStringFormat(String sFormat) {
        this.sFormat = sFormat;
        return this;
    }

    public void setTextNumber(String text) {
        String sFormated = String.format(sFormat, text);
        AnimationTextView.super.setText(sFormated);
    }

    private void setUpAnimator() {
        mCountAnimator = new ValueAnimator();
        mCountAnimator.addUpdateListener(animation -> {

            if (mCountAnimationListener != null) {
                mCountAnimationListener.onAnimationUpdate(animation.getAnimatedValue());
            }

            String value;
            if (mDecimalFormat == null) {
                value = String.valueOf(animation.getAnimatedValue());
            } else {
                value = mDecimalFormat.format(animation.getAnimatedValue());
            }

            if (TextUtils.isEmpty(sFormat)) {
                AnimationTextView.super.setText(value);
                return;
            }
            String sFormated = String.format(sFormat, value);
            AnimationTextView.super.setText(sFormated);
        });

        mCountAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                isAnimating = true;

                if (mCountAnimationListener == null) return;
                mCountAnimationListener.onAnimationStart(mCountAnimator.getAnimatedValue());
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isAnimating = false;

                if (mCountAnimationListener == null) return;
                mCountAnimationListener.onAnimationEnd(mCountAnimator.getAnimatedValue());
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                // do nothing
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // do nothing
            }
        });
        mCountAnimator.setDuration(DEFAULT_DURATION);
    }

    public boolean isRunning() {
        return mCountAnimator.isRunning();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void stopAnim() {
        if (mCountAnimator != null) {
            mCountAnimator.cancel();
        }
    }

    public void pauseAnim() {
        if (mCountAnimator != null) {
            mCountAnimator.pause();
        }
    }

    public void resumeAnim() {
        if (mCountAnimator != null) {
            mCountAnimator.resume();
        }
    }

    public void resetAnimation() {
        isAnimating = false;
        stopAnim();
        clearAnimation();
        setUpAnimator();
    }

    public void countAnimation(int fromValue, int toValue) {
        if (isAnimating) return;

        mCountAnimator.setIntValues(fromValue, toValue);
        mCountAnimator.start();
    }

    public AnimationTextView setAnimationDuration(long duration) {
        mCountAnimator.setDuration(duration);
        return this;
    }

    public AnimationTextView setInterpolator(@NonNull TimeInterpolator value) {
        mCountAnimator.setInterpolator(value);
        return this;
    }


    public abstract static class CountAnimationListener {
        public void onAnimationStart(Object animatedValue) {
        }

        public void onAnimationUpdate(Object animatedValue) {
        }

        public void onAnimationEnd(Object animatedValue) {
        }
    }

    public AnimationTextView setDecimalFormat(DecimalFormat mDecimalFormat) {
        this.mDecimalFormat = mDecimalFormat;
        return this;
    }

    public void clearDecimalFormat() {
        this.mDecimalFormat = null;
    }

    public AnimationTextView setCountAnimationListener(CountAnimationListener mCountAnimationListener) {
        this.mCountAnimationListener = mCountAnimationListener;
        return this;
    }
}
