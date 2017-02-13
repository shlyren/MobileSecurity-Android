package com.shlyren.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by yuxiang on 2017/2/13.
 */

public class HomeScrolTextView extends TextView {
    public HomeScrolTextView(Context context) {
        super(context);
    }

    public HomeScrolTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeScrolTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // 自动获取焦点
    @Override
    public boolean isFocused() {
        return true;
    }
}
