package com.shlyren.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yuxiang on 2017/2/15.
 */

public class ContactEngine {
    //获取系统联系人
    public static List<HashMap<String, String>> getAllContactInfo(Context context) {

        List<HashMap<String, String>> list = null;
        // 获取内容解析这
        ContentResolver contentRes = context.getContentResolver();

        // 获取内容提供者 com.android.contacts

        Uri raw_uri = Uri.parse("content://com.android.contacts/raw_contacts");
        Uri data_uri = Uri.parse("content://com.android.contacts/data");
        Cursor cursor = contentRes.query(raw_uri, new String[]{"contact_id"}, null, null, null);

        HashMap<String, String> map = null;
        while (cursor.moveToNext()) {
            String contact_id = cursor.getString(0);
//            String string = cursor.getString(cursor.getColumnIndex("contact_id"));

            Cursor cursor1 = contentRes.query(data_uri, new String[]{"data1", "mimetype"}, "raw_contact_id", new String[]{contact_id}, null);

            while (cursor1.moveToNext()) {

                String data1 = cursor1.getString(0);
                String mimetype = cursor1.getString(1);
                if (mimetype.equals("vnd.android.cursor.item/phone_v2")) {

                    map.put("phone", data1);

                }else if(mimetype.equals("vnd.android.cursor.item/name")) {

                    map.put("name", data1);
                }

            }
            list.add(map);

            cursor1.close();

        }
        cursor.close();

        return list;
    }
}
