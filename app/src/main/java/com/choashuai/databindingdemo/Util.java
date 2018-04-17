package com.choashuai.databindingdemo;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by chaoshuai on 2018/3/16.
 */

public class Util {
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String u) {
//        RequestOptions options = new RequestOptions()
//                .centerCrop()
//                .placeholder(R.mipmap.ic_launcher_round)
//                .error(R.mipmap.ic_launcher)
//                .priority(Priority.HIGH)
//                .diskCacheStrategy(DiskCacheStrategy.NONE);
//
//        Glide.with(view.getContext()).applyDefaultRequestOptions(options).load(u).transition(new DrawableTransitionOptions().crossFade(1000)).into(view);
        Glide.with(view.getContext()).load(u).into
                (view);
    }

    @BindingAdapter(value = {"passwordd"})
    public static void setTxt(TextView view, CharSequence text) {
        if (text == null) {
            Log.d("BindingAdapter setText", "为空");
            return;
        }

        String s = "";
        for (int i = 0; i < text.length(); i++) {
            s = s + "*";
        }

        view.setText(s);
    }

    public void onMyClick(User user) {
        Log.d("按钮事件", user.content.get() + "");
        user.id.set(1);
        user.quality.put("high", "new H url");
        user.current.set("high");
    }
}
