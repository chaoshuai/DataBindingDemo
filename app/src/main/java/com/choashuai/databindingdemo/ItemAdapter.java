package com.choashuai.databindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;
import static com.choashuai.databindingdemo.BR.user;

/**
 * Created by chaoshuai on 2018/3/16.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private List<User> items;

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item, parent, false);
        ItemViewHolder holder = new ItemViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.getBinding().setVariable(user, items.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setData(List items){
        if (items==null&&items.size()==0) {
            return;
        }
        this.items = items;
    }
}



