package com.shlyren.mobilesecurity;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by yuxiang on 2017/2/14.
 */

public abstract class BaseSetupActivity extends Activity {


    // abstract 抽象方法
    public abstract void next_activity();
    public abstract void pre_activity();


    private GestureDetector ges;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ges = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {

            @Override
            /*
            * 滑动操作
            * e1 按下的事件
            * e2 抬起的事件y
            * velocityX 在X轴移动的速度
            * velocityY 在Y轴移动的速度
            * */
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                float startX = e1.getRawX();
                float endX = e2.getRawX();

                if (Math.abs(e1.getRawY() - e2.getRawY()) > 50) {
                    Toast.makeText(BaseSetupActivity.this, "不支持", Toast.LENGTH_SHORT).show();
                    return false;
                }

                if (startX - endX > 100) { // 下一步
                    nexttip(null);
                } else if (endX - startX > 100) { // 上一步
                    lasttip(null);
                }
                return true;
            }

        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ges.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void nexttip(View view) {

        next_activity();
        overridePendingTransition(R.anim.push_enter_anmi, R.anim.push_exit_anmi);
    }
    public void lasttip(View view) {

        pre_activity();
        overridePendingTransition(R.anim.pop_enter_anmi, R.anim.pop_exit_anmi);
    }

    // 处理返回键
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override //监听手机物理按键的点击
    /*
    * keyCode 物理按键的标识
    * event: 点击事件:
    * boolean: true 屏蔽按键事件
    * */
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            lasttip(null);
        }
        return super.onKeyDown(keyCode, event);

    }
}
