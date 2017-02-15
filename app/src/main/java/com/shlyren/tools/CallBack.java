package com.shlyren.tools;

/**
 * Created by yuxiang on 2017/2/13.
 */

public interface CallBack {

    // 网路请求回调
    interface HttpCallBack {
        /**
         * 请求完成时调用
         */
        void complition(Boolean success, Object result);
    }

}
