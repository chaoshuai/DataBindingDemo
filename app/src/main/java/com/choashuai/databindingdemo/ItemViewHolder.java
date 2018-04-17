package com.choashuai.databindingdemo;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by chaoshuai on 2018/3/16.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;

    public ItemViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public ViewDataBinding getBinding(){
        return this.binding;
    }
}
