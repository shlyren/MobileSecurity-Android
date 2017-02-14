package com.shlyren.mobilesecurity;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by yuxiang on 2017/2/14.
 */

public class LossFindSetup1Activity extends BaseSetupActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lossfindsetup1);
    }

    @Override
    public void next_activity() {
        startActivity(new Intent(this, LossFindSetup2Activity.class));
        finish();

        /*
        * enterAnim 新的界面进入动画
        * exitAnim 旧的界面退出动画
        * */
//        overridePendingTransition(R.anim.push_enter_anmi, R.anim.push_exit_anmi);

    }

    @Override
    public void pre_activity() {

    }
}
