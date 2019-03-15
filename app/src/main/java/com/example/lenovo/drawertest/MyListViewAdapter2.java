package com.example.lenovo.drawertest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.drawertest.R;

import java.util.List;

public class MyListViewAdapter2 extends BaseAdapter {
    private List<Product> data;
    private Context context;
    private boolean isSpeacial;

    public MyListViewAdapter2(List<Product> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data==null?0:data.size();
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
        ViewHolder vh;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_listview_2, null);
            vh = new ViewHolder();
            vh.tvName = (TextView) convertView.findViewById(R.id.goods_name);
            // 初始化  商品简介 价格 图片等控件
            vh.ivProduct=convertView.findViewById(R.id.goods_image);
            vh.tvDesc=convertView.findViewById(R.id.goods_content);
            vh.tvPrice=convertView.findViewById(R.id.goods_price);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Product product=data.get(position);
        vh.tvName.setText(product.getProName());
        //  赋值
        vh.ivProduct.setImageResource(product.getProImgId());
        vh.tvDesc.setText(product.getProDesc());
        vh.tvPrice.setText(product.getProPrice());

        return convertView;
    }


    class ViewHolder {
        TextView tvName;
        TextView tvDesc;
        ImageView ivProduct;
        TextView tvPrice;
    }
}
