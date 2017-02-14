package com.shlyren.mobilesecurity;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by yuxiang on 2017/2/14.
 */

public class LossFindSetup2Activity extends BaseSetupActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lossfindsetup2);
    }

//    public void nexttip(View view) {
//
//    }
//    public void lasttip(View view) {
//
//    }

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
