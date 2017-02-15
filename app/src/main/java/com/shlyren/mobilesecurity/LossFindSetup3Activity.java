package com.shlyren.mobilesecurity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.shlyren.tools.ContactEngine;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yuxiang on 2017/2/14.
 */

public class LossFindSetup3Activity extends BaseSetupActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lossfindsetup3);
        EditText safe_code = (EditText) findViewById(R.id.safe_code);


    }

    // 选择联系人
    public void choose_contact(View view) {

        List<HashMap<String, String>> allContactInfo = ContactEngine.getAllContactInfo(this);

        System.out.println("allContactInfo" + allContactInfo);

    }

    @Override
    public void next_activity() {
        startActivity(new Intent(this, LossFindSetup4Activity.class));
        finish();
    }

    @Override
    public void pre_activity() {
        startActivity(new Intent(this, LossFindSetup2Activity.class));
        finish();
    }
}
