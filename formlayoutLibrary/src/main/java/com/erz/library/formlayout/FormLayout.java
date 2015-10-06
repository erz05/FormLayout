package com.erz.library.formlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Collection;
import java.util.Vector;

/**
 * Created by edgarramirez on 10/5/15.
 */

/* Todo
    1. Validations
    2. Priority
 */
public class FormLayout extends ScrollView {

    Vector<FormField> fields = new Vector<>();
    LinearLayout linearLayout;

    public FormLayout(Context context) {
        super(context, null);
    }

    public FormLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        addView(linearLayout);
    }

    public void setFields(Collection<FormField> fields) {
        this.fields.clear();
        this.fields.addAll(fields);
    }

    public void addField(FormField field) {
        this.fields.add(field);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        FieldEditText editText = new FieldEditText(getContext());
        editText.setLayoutParams(params);
        editText.setHint(field.name);
        linearLayout.addView(editText);
    }
}