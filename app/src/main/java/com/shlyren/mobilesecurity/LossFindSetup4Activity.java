package com.shlyren.mobilesecurity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * Created by yuxiang on 2017/2/14.
 */

public class LossFindSetup4Activity extends BaseSetupActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lossfindsetup4);

        final CheckBox cb_setup_protected = (CheckBox) findViewById(R.id.cb_setup_protected);

        final SharedPreferences setting = getApplication().getSharedPreferences("setting", MODE_PRIVATE);
        cb_setup_protected.setChecked(setting.getBoolean("protected", false));

        cb_setup_protected.setText(cb_setup_protected.isChecked() ? "您已经开启的防盗保护" :"您还未开启防盗保护" );
        cb_setup_protected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                cb_setup_protected.setText(isChecked ? "您已经开启的防盗保护" :"您还未开启防盗保护" );
                SharedPreferences.Editor edit = setting.edit();
                edit.putBoolean("protected", isChecked);
                edit.commit();
            }
        });

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
        finish();
    }

}
