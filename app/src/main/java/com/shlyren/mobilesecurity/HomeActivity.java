package com.shlyren.mobilesecurity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shlyren.tools.StringTool;

/**
 * Created by yuxiang on 2017/2/13.
 */

public class HomeActivity extends Activity {

    private int[] imageId = {R.mipmap.safe, R.mipmap.callmsgsafe, R.mipmap.app,
            R.mipmap.taskmanager, R.mipmap.netmanager, R.mipmap.trojan,
            R.mipmap.sysoptimize, R.mipmap.atools, R.mipmap.settings};
    private String[] names = {"手机防盗", "通讯卫士", "软件管理", "进程管理", "流量统计", "手机杀毒", "缓存清理",
            "高级工具", "设置中心"};
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        GridView gv = (GridView) findViewById(R.id.gv_home_gridView);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        final SharedPreferences pres = getApplication().getSharedPreferences("setting", MODE_PRIVATE);

//                        SharedPreferences.Editor edit = pres.edit();
//                        edit.putString("pwd", "");
//                        edit.commit();
                        final String pwd = pres.getString("pwd", "");

                        final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);

                        builder.setCancelable(false);
                        if (pwd.trim().isEmpty()) {

                            // 为空 设置密码
                            View pwd_view = View.inflate(getApplicationContext(), R.layout.dialog_setpwd, null);
                            builder.setView(pwd_view);

                            final EditText pwdET = (EditText) pwd_view.findViewById(R.id.pwd);
                            final EditText surepwdET = (EditText) pwd_view.findViewById(R.id.sure_pwd);
                            Button cancel = (Button) pwd_view.findViewById(R.id.btn_cancel);
                            Button sure = (Button) pwd_view.findViewById(R.id.sure);

                            sure.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (pwdET.getText().toString().isEmpty()) {
                                        Toast.makeText(HomeActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                                        return;
                                    }

                                    if (!pwdET.getText().toString().trim().equals(surepwdET.getText().toString().trim())) {
                                        Toast.makeText(HomeActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                                        return;
                                    }

                                    Toast.makeText(HomeActivity.this, "设置成功", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                    SharedPreferences.Editor editor = pres.edit();
                                    String pwd_str = pwdET.getText().toString().trim();

                                    editor.putString("pwd", StringTool.MD5(pwd_str));
                                    editor.commit();
                                }
                            });

                            cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });

                        } else {
                            // 验证密码
                            View inputpwd_view = View.inflate(getApplicationContext(), R.layout.dialog_inputpwd, null);
                            builder.setView(inputpwd_view);

                            final EditText pwdET = (EditText) inputpwd_view.findViewById(R.id.pwd);
                            Button sure = (Button) inputpwd_view.findViewById(R.id.sure);
                            sure.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String input_pwd = pwdET.getText().toString().trim();
                                    if (StringTool.MD5(input_pwd).equals(pwd)){

                                        startActivity(new Intent(HomeActivity.this, LossFindActivity.class));
                                        dialog.dismiss();
                                    }else {
                                        Toast.makeText(HomeActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            Button cancel = (Button) inputpwd_view.findViewById(R.id.btn_cancel);
                            cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                        }

                        dialog = builder.create();
                        dialog.show();
                        break;
                    }
                    case 8: {
                        Intent intent = new Intent(HomeActivity.this, SettingActivity.class);
                        startActivity(intent);
                        break;
                    }

                    default:
                        break;
                }
            }
        });
        gv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return imageId.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view;
                if (convertView == null) {
                    view = View.inflate(getApplicationContext(), R.layout.item_home, null);
                } else {
                    view = convertView;
                }

                ImageView imgV = (ImageView) view.findViewById(R.id.imageView);
                TextView textV = (TextView) view.findViewById(R.id.textView);
                imgV.setImageResource(imageId[position]);
                textV.setText(names[position]);

                return view;
            }
        });
    }

}
