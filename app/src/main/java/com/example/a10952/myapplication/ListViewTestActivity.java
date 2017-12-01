package com.example.a10952.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewTestActivity extends AppCompatActivity {
    private String[] date ={"a","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                ListViewTestActivity.this,android.R.layout.simple_list_item_1,date
        );
        ListView listView=(ListView)findViewById(R.id.nlist);
        listView.setAdapter(adapter);
    }
}
