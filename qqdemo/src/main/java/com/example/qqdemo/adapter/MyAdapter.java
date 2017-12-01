package com.example.qqdemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qqdemo.View.SlideItem;
import com.example.qqdemo.entity.Furit;
import com.example.qqdemo.R;
import com.example.qqdemo.View.CircleImageView;

import java.util.List;

/**
 * Created by 10952 on 2017/11/23.
 */

public class MyAdapter extends BaseAdapter {
    private List<Furit> list;
    private LayoutInflater inflater;//将布局转换成View
    private Context context;

    public MyAdapter(List<Furit> list, Context context) {
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.context = context;
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
        if (convertView == null) {
            View content = inflater.inflate(R.layout.qq_item, null);
            h = new HorldView();
            h.tvText = (TextView) content.findViewById(R.id.qq_list);
            h.ivImg = (CircleImageView) content.findViewById(R.id.qq_img);

            View menu = inflater.inflate(R.layout.slide_menu, null);
            h.tvDel = (TextView) menu.findViewById(R.id.tv_del);

            SlideItem item = new SlideItem(context);
            item.setContentView(content, menu);
            convertView = item;

            convertView.setTag(h);
            Log.d("Tag", "调试信息" + position);
        } else {
            h = (HorldView) convertView.getTag();
        }
        Furit fu = list.get(position);
        h.tvText.setText(fu.getName());
        h.ivImg.setImageResource(fu.getImageId());
        return convertView;
    }

    class HorldView {//用属性来保存控件，然后将这个类保存起来
        public TextView tvText;
        public CircleImageView ivImg;
        private TextView tvDel;
    }
}
