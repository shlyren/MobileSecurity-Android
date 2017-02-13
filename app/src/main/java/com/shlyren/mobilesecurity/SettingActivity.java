package com.shlyren.mobilesecurity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by yuxiang on 2017/2/13.
 */
public class SettingActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final TextView updateTv = (TextView)findViewById(R.id.tv_setting_dsc);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.cb_setting_update);
        final SharedPreferences pre = getApplication().getSharedPreferences("setting", MODE_PRIVATE);

        checkBox.setChecked(pre.getBoolean("update", true));

        if (!checkBox.isChecked()) {
            updateTv.setText("关闭提示更新");
        }else {
            updateTv.setText("开启提示更新");
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    updateTv.setText("关闭提示更新");
                }else {
                    updateTv.setText("开启提示更新");
                }
                SharedPreferences.Editor editor = pre.edit();
                editor.putBoolean("update", isChecked);
                editor.commit();
            }
        });
    }


}
