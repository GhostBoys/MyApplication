package com.example.a10952.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);    //启动APP时使用的布局文件
        TextView zuce = (TextView) findViewById(R.id.zhuce);
        Button btndl = (Button) findViewById(R.id.btn_dl);
        /*zhuce.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
            }
        });*/
        zuce.setOnClickListener(this);
        btndl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zhuce:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_dl:
                Toast.makeText(MainActivity.this, "登录按钮", Toast.LENGTH_LONG).show();
        }
    }
}

//        Button btndl = (Button) findViewById(R.id.btn_dl);
//        Button btnd2 = (Button) findViewById(R.id.btn_dl01);
//        Button btnd3 = (Button) findViewById(R.id.btn_dl02);
//
//        btndl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "按钮登录", Toast.LENGTH_LONG).show();
//            }
//        });
//        btnd2.setOnClickListener(this);
//    }
//
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_dl01:
//                break;
//            case R.id.btn_dl02:
//                Toast.makeText(MainActivity.this, "按钮登录", Toast.LENGTH_LONG).show();
//                break;
//        }
//    }
//    public class MyListener implements View.OnClickListener {
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(MainActivity.this, "按钮03", Toast.LENGTH_LONG).show();
//        }
//    }

