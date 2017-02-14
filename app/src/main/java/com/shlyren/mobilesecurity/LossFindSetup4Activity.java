package com.shlyren.mobilesecurity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

/**
 * Created by yuxiang on 2017/2/14.
 */

public class LossFindSetup4Activity extends BaseSetupActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lossfindsetup4);
    }

    @Override
    public void next_activity() {

    }

    //
    @Override
    public void pre_activity() {
        startActivity(new Intent(this, LossFindSetup3Activity.class));
        finish();
    }

    public void setdone(View v){

        SharedPreferences setting = getApplicationContext().getSharedPreferences("setting", MODE_PRIVATE);
        SharedPreferences.Editor edit = setting.edit();
        edit.putBoolean("first_setting_lossFind", false);
        edit.commit();
        startActivity(new Intent(this, LossFindActivity.class));
        finish();
    }

}
