package com.choashuai.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by chaoshuai on 2018/3/16.
 */

public class UserT extends BaseObservable {
    public final ObservableInt id = new ObservableInt();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> url = new ObservableField<>();
}
