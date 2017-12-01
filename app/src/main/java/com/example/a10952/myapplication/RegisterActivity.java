package com.example.a10952.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private List<String> list = new ArrayList<String>();
    private TextView mEsc;
    private Spinner mAge;
    private ArrayAdapter<String> adapter;
    private String[] ages;
    private String agee;
    private TextView userName;
    private EditText userPwd;
    private EditText userPwds;
    private Button btn_zc;
    private Intent intent;
    private RadioGroup rgSex;
    private String sex="男";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglogin);
        mEsc = (TextView) findViewById(R.id.reg_back);
        mAge = (Spinner) findViewById(R.id.reg_age);
        userName = (TextView) findViewById(R.id.uName);
        userPwd = (EditText) findViewById(R.id.uPwd);
        userPwds = (EditText) findViewById(R.id.uPwds);
        btn_zc=(Button)findViewById(R.id.btn_zc);

        list.add("1-10");
        list.add("11-20");
        list.add("21-30");
        list.add("31-40");
        list.add("41-50");
        list.add("51-60");
        list.add("61-70");

        ages = new String[]{"5-10", "10-15", "15-20","20-25","25-30","30-35","35-40"};
        Log.v("tag", list.size() + "");
        adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, ages);
        mAge.setAdapter(adapter);
        mAge.setSelection(0);
        mAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                agee = ages[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        rgSex=(RadioGroup)findViewById(R.id.re_sex);
        rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId==R.id.rb_01){
                    sex="男";
                }else{
                    sex="女";
                }

            }
        });



        //adapter = ArrayAdapter.createFromResource(this, list, R.layout.support_simple_spinner_dropdown_item);
        //adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //mAge.setVisibility(View.VISIBLE);
        mEsc.setOnClickListener(this);
        btn_zc.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reg_back:
                intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_zc:
                String name = userName.getText().toString();
                String password = userPwd.getText().toString();
                String passwords = userPwds.getText().toString();
                if (name.equals(null) || password.equals("") || passwords.equals("")) {
                    Toast.makeText(this, "请输入完整信息", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!password.equals(passwords)) {
                    Toast.makeText(this, "两次密码不一致,请重新输入", Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
                intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

}
