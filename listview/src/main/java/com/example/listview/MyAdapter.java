package com.example.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listview.View.CircleImageView;

import java.util.List;

/**
 * Created by 10952 on 2017/11/23.
 */

public class MyAdapter extends BaseAdapter {
    private List<Furit> list;
    private LayoutInflater inflater;
    public MyAdapter(List<Furit> list, Context context){
        this.list=list;
        inflater=LayoutInflater.from(context);
    }

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
        HorldView h;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.qq_item,null);
            h = new HorldView();
            h.tvText=(TextView)convertView.findViewById(R.id.qq_list);
            h.ivImg=(CircleImageView) convertView.findViewById(R.id.qq_img);
            convertView.setTag(h);
            Log.d("Tag","调试信息"+position);
        }
        else {
            h=(HorldView)convertView.getTag();
        }
        Furit fu=list.get(position);
        h.tvText.setText(fu.getName());
        h.ivImg.setImageResource(fu.getImageId());
        return convertView;
    }
    class HorldView{
        public TextView tvText;
        public CircleImageView ivImg;
    }
}
