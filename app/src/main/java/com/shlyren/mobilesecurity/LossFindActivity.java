package com.shlyren.mobilesecurity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/*
 * Created by yuxiang on 2017/2/14.
 */
public class LossFindActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences setting = getApplicationContext().getSharedPreferences("setting", MODE_PRIVATE);
        if (setting.getBoolean("first_setting_lossFind", true)) {
            startActivity(new Intent(this, LossFindSetup1Activity.class));
            finish();
        }else {
            setContentView(R.layout.activity_lossfind);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences setting = getApplicationContext().getSharedPreferences("setting", MODE_PRIVATE);
//        TextView num_tv = (TextView) findViewById(R.id.num_tv);
        ImageView img_protected = (ImageView) findViewById(R.id.img_protected);

        if (setting.getBoolean("protected", false)) {

            img_protected.setImageResource(R.mipmap.lock);
        }else  {
            img_protected.setImageResource(R.mipmap.unlock);
        }
    }

    public void resetting(View v){
        startActivity(new Intent(this, LossFindSetup1Activity.class));
    }

}
