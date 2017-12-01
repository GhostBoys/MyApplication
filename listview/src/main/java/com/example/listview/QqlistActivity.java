package com.example.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class QqlistActivity extends Activity {
    private String[] newinfo = new String[]{"图片01", "图片02", "图片03", "图片04", "图片05", "图片06", "图片07", "图片08", "图片09", "图片10", "图片11", "图片12"};
    private int[] imgs = new int[]{R.mipmap.img_01, R.mipmap.img_02, R.mipmap.img_03, R.mipmap.img_04, R.mipmap.img_05, R.mipmap.img_06, R.mipmap.img_07, R.mipmap.img_08, R.mipmap.img_09, R.mipmap.img_10, R.mipmap.img_11, R.mipmap.img_12};
    private List<Furit> date = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqlist);
        ListView listView = (ListView) findViewById(R.id.lv_list);
        intData();
        MyAdapter adapter = new MyAdapter(date, this);
        listView.setAdapter(adapter);

    }

    private void intData() {
        for (int i = 0; i < imgs.length; i++) {
            Furit fu = new Furit(newinfo[i],imgs[i]);
            date.add(fu);
            date.add(fu);
        }
    }
}
