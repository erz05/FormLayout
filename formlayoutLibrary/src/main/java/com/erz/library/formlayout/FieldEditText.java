package com.erz.library.formlayout;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by edgarramirez on 10/5/15.
 */
public class FieldEditText extends EditText {

    float textSize;
    float padding;
    float posFraction;
    boolean showLabel;
    int textColor;
    CharSequence labelText = "";

    ArgbEvaluator focusEvaluator = new ArgbEvaluator();
    TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    ObjectAnimator labelAnimator = ObjectAnimator.ofFloat(this, "posFraction", 0f, 1f);

    public FieldEditText(Context context) {
        super(context);
        init(context, null);
    }

    public FieldEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setBackgroundColor(Color.TRANSPARENT);
        labelText = getHint();
        padding = 30;
        textSize = getTextSize();
        textColor = Color.BLACK;

        textPaint.setTextSize(textSize);
        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

        CharSequence text = getText();
        if (text.length() > 0) {
            setText(null);
            setText(text);
            setSelection(text.length());
            posFraction = 1;
            showLabel = true;
        }

        labelAnimator.setDuration(300);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    if (showLabel) {
                        showLabel = false;
                        labelAnimator.reverse();
                    }
                } else if (!showLabel) {
                    showLabel = true;
                    if (labelAnimator.isRunning()) labelAnimator.reverse();
                    else labelAnimator.start();
                }
            }
        });
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        if (labelText == null) labelText = getHint();
        if (labelText != null && labelText.length() > 0) {
            textPaint.setColor((Integer) focusEvaluator.evaluate(posFraction, Color.TRANSPARENT, textColor));
            float floatingLabelStartY = getPaddingTop() + (textSize/2);
            int position = (int) (floatingLabelStartY - padding * posFraction);
            canvas.drawText(labelText.toString(), getScrollX(), position, textPaint);
        }

        super.draw(canvas);

        canvas.drawLine(0, canvas.getHeight() - 2, canvas.getWidth(), canvas.getHeight() - 2, textPaint);
    }

    public float getPosFraction() {
        return posFraction;
    }

    public void setPosFraction(float posFraction) {
        this.posFraction = posFraction;
        setPadding(getPaddingLeft(), (int) (textSize * posFraction), getPaddingRight(), getPaddingBottom());
    }
}
