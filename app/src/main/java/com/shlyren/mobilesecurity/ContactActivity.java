package com.shlyren.mobilesecurity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shlyren.tools.AsycnTask;
import com.shlyren.tools.ContactEngine;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yuxiang on 2017/2/15.
 */
public class ContactActivity extends Activity  {
    private List<HashMap<String, String>> list;

    @ViewInject(R.id.list_view) private ListView listView;
    @ViewInject(R.id.progress) private ProgressBar loading;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        new AsycnTask() {

            @Override
            public void preTask() {
                x.view().inject(ContactActivity.this);
            }

            @Override
            public void doninBack() {
                list = ContactEngine.getAllContactInfo(getApplicationContext());
            }

            @Override
            public void postTask() {
                listView.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return list.size();
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
                            view = View.inflate(getApplicationContext(), R.layout.item_contact, null);
                        } else {
                            view = convertView;
                        }

                        TextView name_tv = (TextView) view.findViewById(R.id.name);
                        TextView phone_tv = (TextView) view.findViewById(R.id.phone);
                        name_tv.setText(list.get(position).get("name"));
                        phone_tv.setText(list.get(position).get("phone"));

                        return view;
                    }
                });

                loading.setVisibility(View.INVISIBLE);
            }
        }.execute();


//        new AsyncTask<Void, Void, Void>() {
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//            }
//
//            @Override
//            protected Void doInBackground(Void... params) {
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                super.onPostExecute(aVoid);
//            }
//        }.execute();


    }
}
