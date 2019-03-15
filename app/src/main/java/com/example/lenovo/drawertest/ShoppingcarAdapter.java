package com.example.lenovo.drawertest;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class ShoppingcarAdapter extends BaseAdapter {


    private List<Product> shoppingCar;
    private Context context;
    //设置接口
    private View.OnClickListener onAddNum;
    private View.OnClickListener onSubNum;

    //设置接口方法
    public void setOnAddNum(View.OnClickListener onAddNum){
        this.onAddNum = onAddNum;
    }

    public void setOnSubNum(View.OnClickListener onSubNum){
        this.onSubNum = onSubNum;
    }
    //创建构造方法
    public ShoppingcarAdapter(List<Product> products, Context context) {
        this.shoppingCar = products;
        this.context = context;
    }
    //定义内部类
    private static class ViewHolder{
        //商品名称，图片，内容，数量，总价
        private TextView item_product_name;
        private ImageView item_product_img;
        private TextView item_product_content;
        private TextView item_product_num;
        private TextView item_product_price;
        //增减商品数量按钮
        private TextView item_btn_add;
        private TextView item_btn_sub;

    }
    //重写适配器方法
    @Override
    public int getCount() {
        int ret = 0;
        if (shoppingCar != null) {
            ret = shoppingCar.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int i) {
        return shoppingCar.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder ;
        if (view != null) {
            holder= (ViewHolder) view.getTag();
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.item3,viewGroup,false);
            holder = new ViewHolder();
            holder.item_product_name = (TextView) view.findViewById(R.id.goods_name);
            holder.item_product_img = (ImageView) view.findViewById(R.id.goods_image);
            holder.item_product_content = (TextView) view.findViewById(R.id.goods_content);
            holder.item_product_num = (TextView) view.findViewById(R.id.goods_number);
            holder.item_product_price = (TextView) view.findViewById(R.id.goods_price);
            holder.item_btn_add = (TextView) view.findViewById(R.id.add);
            holder.item_btn_sub = (TextView)view.findViewById(R.id.subtract);
            view.setTag(holder);
        }

        Product product = shoppingCar.get(i);
        holder.item_product_name.setText(product.getProName());
        holder.item_product_img.setImageResource(product.getProImgId());
        holder.item_product_content.setText(product.getProDesc());
        holder.item_product_num.setText(product.getProNum()+"");
        holder.item_product_price.setText(product.getProPrice() + "");

        //设置Tag，点击加减号
        holder.item_btn_add.setTag(i);
        holder.item_btn_sub.setTag(i);

        return view;
    }

}