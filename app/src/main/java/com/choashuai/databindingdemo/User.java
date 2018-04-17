package com.choashuai.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableMap;

/**
 * Created by chaoshuai on 2018/3/15.
 */

public class User extends BaseObservable{
    public final ObservableInt id = new ObservableInt();
    public final ObservableField<String> name = new ObservableField<>();
    public String blog;
    public final ObservableField<String> url = new ObservableField<>();
    public final ObservableMap<String, Object> quality = new ObservableArrayMap<>();
    public final ObservableField<String> current = new ObservableField<>();
    public final ObservableField<String> content = new ObservableField<>();

    public User(){

    }

    @Bindable
    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
        notifyPropertyChanged(BR.blog);
    }
}
