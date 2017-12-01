package com.example.qqdemo;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
    private TabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabhost = getTabHost();
        TabHost.TabSpec tab1 = tabhost.newTabSpec("tab1");
        View v1 = LayoutInflater.from(this).inflate(R.layout.tab_log1, null);
        tab1.setIndicator(v1);
        tab1.setContent(new Intent(this, QqlistActivity.class));
        tabhost.addTab(tab1);

        View v2 = LayoutInflater.from(this).inflate(R.layout.tab_log2, null);
        TabHost.TabSpec tab2 = tabhost.newTabSpec("tab2");
        tab2.setIndicator(v2);
        tab2.setContent(new Intent(this, InfoActivity.class));
        tabhost.addTab(tab2);

        View v3 = LayoutInflater.from(this).inflate(R.layout.tab_log3, null);
        TabHost.TabSpec tab3 = tabhost.newTabSpec("tab3");
        tab3.setIndicator(v3);
        tab3.setContent(new Intent(this, DontaiActivity.class));
        tabhost.addTab(tab3);
    }
}
