package com.choashuai.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.ObservableInt;

/**
 * Created by chaoshuai on 2018/3/21.
 */

public class Progress extends BaseObservable {
    public final ObservableInt porgress = new ObservableInt();
}