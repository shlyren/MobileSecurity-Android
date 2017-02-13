package com.shlyren.mobilesecurity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yuxiang on 2017/2/13.
 */

public class HomeActivity extends Activity {

    private int[] imageId = { R.mipmap.safe, R.mipmap.callmsgsafe, R.mipmap.app,
            R.mipmap.taskmanager, R.mipmap.netmanager, R.mipmap.trojan,
            R.mipmap.sysoptimize, R.mipmap.atools, R.mipmap.settings };
    private String[] names = { "手机防盗", "通讯卫士", "软件管理", "进程管理", "流量统计", "手机杀毒", "缓存清理",
            "高级工具", "设置中心" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        GridView gv = (GridView) findViewById(R.id.gv_home_gridView);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 8:

                        Intent intent = new Intent(HomeActivity.this, SettingActivity.class);
                        startActivity(intent);
                        break;

                    default:break;
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
                }else {
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
