package com.example.listview;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
private TabHost tabhost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabhost=getTabHost();
        TabHost.TabSpec tab1=tabhost.newTabSpec("tab1");
        tab1.setIndicator(R.mipmap.skin_tab_icon_conversation_normal);
        tab1.setContent(new Intent(this,QqlistActivity.class));
        tabhost.addTab(tab1);
    }
}
