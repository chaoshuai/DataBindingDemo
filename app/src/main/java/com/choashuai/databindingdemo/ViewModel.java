package com.choashuai.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;

/**
 * Created by chaoshuai on 2018/3/20.
 */

public class ViewModel extends BaseObservable {
    public final ObservableBoolean isDisplay = new ObservableBoolean();
}
