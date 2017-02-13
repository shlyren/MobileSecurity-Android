package com.shlyren.mobilesecurity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.shlyren.tools.CallBack;
import com.shlyren.tools.HttpTool;

import java.util.Timer;
import java.util.TimerTask;


public class SpalshActivity extends AppCompatActivity {


    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            jump();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        TextView versionTV = (TextView) findViewById(R.id.version_tv);

        PackageManager packageManager = getPackageManager();
        try {
            //0: 获取基础信息,比如包名,版本信息
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            versionTV.setText("版本号:" + packageInfo.versionName);

        } catch (PackageManager.NameNotFoundException e) {
            // 包名找不到异常
            e.printStackTrace();
        } finally { // 不管有没有异常 都会执行

            SharedPreferences pre = getApplication().getSharedPreferences("setting", MODE_PRIVATE);

            if (!pre.getBoolean("update", true)) {

                Timer timer = new Timer();
                timer.schedule(task, 2000);

                return;
            }
            final AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setCancelable(false);
            alert.setTitle("提示");
            alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alert.setCancelable(true);
                    jump();
                }
            });

            alert.show();
        }

    }

    protected void jump() {
        Intent intent = new Intent(SpalshActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    protected void downLoad() {

        HttpTool.POST("http://www.baidu,com", null, new CallBack.HttpCallBack() {
            @Override
            public void complition(Boolean success, Object result) {

                System.out.println("complition: " + success + result);
            }
        });

    }

}





























