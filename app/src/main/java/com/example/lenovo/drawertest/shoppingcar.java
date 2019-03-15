package com.example.lenovo.drawertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.drawertest.Product;
import com.example.lenovo.drawertest.ShoppingCarBean;
import com.example.lenovo.drawertest.ShoppingcarAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class shoppingcar extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ShoppingCarBean datas;
    private ListView lvProducts;
    private List<Product> products; //传递过来的数据，需要做商品数量叠加处理
    private List<Product> productDatas;//现在展示的数据
    private ShoppingcarAdapter adapter;
    private TextView tvNum,tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcar);
        initData();
        initView();
    }

    private void initView() {
        lvProducts=findViewById(R.id.lvProducts);
        adapter=new ShoppingcarAdapter(products,shoppingcar.this);
        lvProducts.setAdapter(adapter);
        lvProducts.setOnItemClickListener(this);
        tvNum=findViewById(R.id.number);
        tvPrice=findViewById(R.id.price);

        tvNum.setText(datas.getTotalNum()+"");
        tvPrice.setText(datas.getTotalPrice()+"");
    }

    private void initData() {
        Intent intent = getIntent();
        if(null!=intent.getSerializableExtra("datas")){
            datas = (ShoppingCarBean) intent.getSerializableExtra("datas");
        }
        products=datas.getProducts();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView add =view.findViewById(R.id.add);
        TextView subtract=view.findViewById(R.id.subtract);
        final Product product = products.get(i);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.setProNum(product.getProNum()+1);
                adapter.notifyDataSetChanged();
                refreshDatas();
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(product.getProNum()>1){
                    product.setProNum(product.getProNum()-1);
                }else{
                    products.remove(product);
                }
                adapter.notifyDataSetChanged();
                refreshDatas();
            }
        });
    }

    private void refreshDatas() {
        int totalNum=0,totalPrice=0;

        for (Product product : products) {
            totalNum+=product.getProNum();
            totalPrice+=(product.getProNum()*Integer.parseInt(product.getProPrice()));
        }
        datas.setTotalNum(totalNum);
        datas.setTotalPrice(totalPrice);
        datas.setProducts(products);

        tvNum.setText(totalNum+"");
        tvPrice.setText(totalPrice+"");

    }


    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("datas",datas);
        setResult(2002,intent);
        super.onBackPressed();
    }
}
