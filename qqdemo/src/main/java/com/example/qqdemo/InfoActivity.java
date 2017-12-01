package com.example.qqdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InfoActivity extends AppCompatActivity {
    private String[] groups = new String[]{"我的好友", "我的家人", "我的游戏好友", "不认识的人"};
    //private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

    }
}
