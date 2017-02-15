package com.shlyren.tools;

import android.os.Handler;
import android.os.Message;

/*
 * Created by yuxiang on 2017/2/15.
 */

public abstract class AsycnTask {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            postTask();
        }
    };

    /**
     * 在子线程之前调用
     */
    public abstract void preTask();

    /**
     * 在子线程中调用
     */
    public abstract void doninBack();

    /**
     * 子线程之后调用
     */
    public abstract void postTask();

    /**
     * 执行
     */
    public void execute() {
        preTask();
        new Thread() {
            @Override
            public void run() {
                doninBack();
                handler.sendEmptyMessage(0);
            }
        }.start();
    }

}
