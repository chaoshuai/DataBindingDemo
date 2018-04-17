package com.choashuai.databindingdemo;

import android.content.Context;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by chaoshuai on 2018/3/20.
 */
@BindingMethods({@BindingMethod(type = TextView.class, attribute = "zhangphiltoast", method = "showZhangPhilToast")})
public class PhilTextView extends android.support.v7.widget.AppCompatTextView {
    public PhilTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void showZhangPhilToast(String s) {
        if (TextUtils.isEmpty(s)) {
            return;
        }

        Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
    }
}
