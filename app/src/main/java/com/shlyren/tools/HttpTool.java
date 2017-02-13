package com.shlyren.tools;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

public class HttpTool {

    public static void POST(String url, Map param, final CallBack.HttpCallBack httpCallBack) {
        RequestParams params = new RequestParams(url);

        x.http().get(params, new Callback.CommonCallback<Object>() {

            @Override
            public void onSuccess(Object result) {
                if (result == null) {
                    httpCallBack.complition(false, "请求失败: 没有数据");
                }else {
                    httpCallBack.complition(true, result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                httpCallBack.complition(false, "请求失败: 网络错误!");
            }

            @Override
            public void onCancelled(CancelledException cex) {
//                httpCallBack.complition(false, result);
            }

            @Override
            public void onFinished() {
//                System.out.println("onFinished");
            }
        });

    }
}
