package com.shlyren.mobilesecurity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by yuxiang on 2017/2/14.
 */

public class LossFindSetup2Activity extends BaseSetupActivity {

    private CheckBox cb_banding_sim;
    private TextView tv_banding_sim;
    private SharedPreferences setting;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lossfindsetup2);

        cb_banding_sim = (CheckBox) findViewById(R.id.cb_banding_sim);
        tv_banding_sim = (TextView) findViewById(R.id.tv_banding_sim);
        setting = getApplication().getSharedPreferences("setting", MODE_PRIVATE);

        cb_banding_sim.setChecked(!setting.getString("sim_num", "").isEmpty());

        if (cb_banding_sim.isChecked()) {
            tv_banding_sim.setText("sim卡已绑定");

        }else {
            tv_banding_sim.setText("sim卡未绑定");
        }

    }

    public void banding_sim(View view) {

        SharedPreferences.Editor edit = setting.edit();

        if (cb_banding_sim.isChecked()) { // 解绑

            edit.putString("sim_num", "");
            tv_banding_sim.setText("sim卡未绑定");

        }else { //绑定

//            TelephonyManager tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
//            String line1Number = tm.getLine1Number(); // 获取sim绑定的电话号码
//            String sim = tm.getSimSerialNumber(); // 获取sim卡序列号
            edit.putString("sim_num", "sim");
            tv_banding_sim.setText("sim卡已绑定");
        }
        cb_banding_sim.setChecked(!cb_banding_sim.isChecked());
        edit.commit();
    }

    @Override
    public void next_activity() {
        startActivity(new Intent(this, LossFindSetup3Activity.class));
        finish();
    }

    @Override
    public void pre_activity() {

        startActivity(new Intent(this, LossFindSetup1Activity.class));
        finish();
    }

}
