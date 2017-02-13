package com.shlyren.mobilesecurity;

import android.app.Application;

import org.xutils.x;

/**
 * Created by yuxiang on 2017/2/13.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
