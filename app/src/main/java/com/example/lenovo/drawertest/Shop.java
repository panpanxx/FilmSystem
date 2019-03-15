package com.example.lenovo.drawertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.drawertest.MyListViewAdapter1;
import com.example.lenovo.drawertest.MyListViewAdapter2;
import com.example.lenovo.drawertest.Product;
import com.example.lenovo.drawertest.ShoppingCarBean;
import com.example.lenovo.drawertest.ShoppingcarAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shop extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener {


    //数据准备
    private int selectIndex = 0;
    private int totalPrice;
    private ListView mListView1, mListView2;
    private MyListViewAdapter1 adapter1;
    private MyListViewAdapter2 adapter2;
    private ShoppingcarAdapter adapter3;
    private static final String[] mMenus = {"特惠套餐", "冰激凌", "COSTA咖啡", "爆米花", "现调冰饮", "现调热饮", "瓶装饮料", "小食品", "衍生品"};

    private HashMap<String, List<Product>> totalDatas;
    private List<Product> products;
    private List<Product> shoppingCar;
    private TextView tvProNum, tvPrice;
    private TextView enter;
    private ShoppingCarBean bean;

    //输入数据
    private void initData() {
        bean=new ShoppingCarBean();
        totalPrice = 0;
        products = new ArrayList<>();
        totalDatas = new HashMap<>();
        shoppingCar = new ArrayList<>();
        /*
        特惠套餐集合
         */
        ArrayList<Product> mealSetList = new ArrayList<>();
        Product hotMeal = new Product();//人气套餐
        hotMeal.setProName("人气套餐");
        hotMeal.setProDesc("爆米花盒装85oz*1+现调可乐22oz*2+法国进口Barnier棒棒糖*1");
        hotMeal.setProImgId(R.drawable.goods1_1);
        hotMeal.setProPrice("49");
        mealSetList.add(hotMeal);

        Product ordinaryMeal = new Product();//经典套餐
        ordinaryMeal.setProName("经典套餐");
        ordinaryMeal.setProDesc("爆米花盒装85oz*1+雀巢奶茶12oz*2");
        ordinaryMeal.setProImgId(R.drawable.goods1_2);
        ordinaryMeal.setProPrice("39");
        mealSetList.add(ordinaryMeal);

        Product singleMeal = new Product();//脱单套餐
        singleMeal.setProName("脱单套餐");
        singleMeal.setProDesc("可口可乐瓶装水动力 600ml*1+爆米花桶装46oz*1");
        singleMeal.setProImgId(R.drawable.goods1_3);
        singleMeal.setProPrice("29");
        mealSetList.add(singleMeal);
        totalDatas.put("特惠套餐", mealSetList);
        //右边列表初始化应该是第一个选中状态
        products.addAll(mealSetList);

        /**
         * 冰激凌集合
         */
        ArrayList<Product> icecreams = new ArrayList<>();//冰激凌
        Product iceA = new Product();//冰淇淋A
        iceA.setProName("哈根达斯小杯装");
        iceA.setProDesc("哈根达斯小杯装 100ml*1");
        iceA.setProImgId(R.drawable.goods2_1);
        iceA.setProPrice("39");
        icecreams.add(iceA);

        Product iceB = new Product();//冰淇淋B
        iceB.setProName("哈根达斯买一送一");
        iceB.setProDesc("哈根达斯单球杯*1");
        iceB.setProImgId(R.drawable.goods2_2);
        iceB.setProPrice("35");
        icecreams.add(iceB);
        totalDatas.put("冰激凌", icecreams);

        /**
         * 咖啡集合
         */
        ArrayList<Product> coffeeList = new ArrayList<>();//咖啡
        Product coffeeA = new Product();//咖啡A
        coffeeA.setProName("Costa单人餐");
        coffeeA.setProDesc("拿铁_中_全脂*1+咖世家提拉米苏*1+外带热饮*1");
        coffeeA.setProImgId(R.drawable.goods3_1);
        coffeeA.setProPrice("49");
        coffeeList.add(coffeeA);

        Product coffeeB = new Product();//咖啡B
        coffeeB.setProName("饮品组合APP");
        coffeeB.setProDesc("冰美式_中*1+卡布奇诺_中_全脂*1+外带冰饮中杯*1");
        coffeeB.setProImgId(R.drawable.goods3_2);
        coffeeB.setProPrice("40");
        coffeeList.add(coffeeB);

        Product coffeeC = new Product();//咖啡C
        coffeeC.setProName("经典咖啡酷乐冰");
        coffeeC.setProDesc("经典咖啡酷乐冰_小_全脂*1+外带冰饮中杯*1");
        coffeeC.setProImgId(R.drawable.goods3_3);
        coffeeC.setProPrice("33");
        coffeeList.add(coffeeC);

        Product coffeeD = new Product();//咖啡D
        coffeeD.setProName("芒果百香果酷乐冰");
        coffeeD.setProDesc("芒果百香果酷乐冰_小*1+外带冰饮中杯*1");
        coffeeD.setProImgId(R.drawable.goods3_4);
        coffeeD.setProPrice("33");
        coffeeList.add(coffeeD);

        Product coffeeE = new Product();//咖啡E
        coffeeE.setProName("拿铁APP");
        coffeeE.setProDesc("拿铁_中_全脂*1+外带冰饮中杯*1");
        coffeeE.setProImgId(R.drawable.goods3_5);
        coffeeE.setProPrice("31");
        coffeeList.add(coffeeE);

        Product coffeeF = new Product();//咖啡F
        coffeeE.setProName("摩卡APP");
        coffeeF.setProDesc("摩卡_小_全脂*1+外带冰饮中杯*1");
        coffeeF.setProImgId(R.drawable.goods3_6);
        coffeeF.setProPrice("31");
        coffeeList.add(coffeeF);

        Product coffeeG = new Product();//咖啡G
        coffeeG.setProName("冰美式APP");
        coffeeG.setProDesc("冰美式_小*1+外带冰饮中杯*1");
        coffeeG.setProImgId(R.drawable.goods3_7);
        coffeeG.setProPrice("29");
        coffeeList.add(coffeeG);
        totalDatas.put("COSTA咖啡", coffeeList);

        /**
         * 爆米花集合
         */
        ArrayList<Product> popcorn = new ArrayList<>();//
        Product popA = new Product();//爆米花A
        popA.setProName("大爆");
        popA.setProDesc("爆米花桶装120oz*1");
        popA.setProImgId(R.drawable.goods4_1);
        popA.setProPrice("35");
        popcorn.add(popA);

        Product popB = new Product();//爆米花B
        popB.setProName("一桶江山爆");
        popB.setProDesc("爆米花桶装85oz*2");
        popB.setProImgId(R.drawable.goods4_2);
        popB.setProPrice("33");
        popcorn.add(popB);
        totalDatas.put("爆米花", popcorn);


        /**
         * 现调冰饮集合
         */
        ArrayList<Product> icedrink = new ArrayList<>();//
        Product icedrinkA = new Product();//现调冰饮A
        icedrinkA.setProName("现调可乐32oz");
        icedrinkA.setProDesc("现调可乐32oz*1");
        icedrinkA.setProImgId(R.drawable.goods5_1);
        icedrinkA.setProPrice("10");
        icedrink.add(icedrinkA);

        Product icedrinkB = new Product();//现调冰饮B
        icedrinkB.setProName("草莓昔果乐");
        icedrinkB.setProDesc("雀巢昔果乐奇异果草莓可乐杯16oz*1");
        icedrinkB.setProImgId(R.drawable.goods5_2);
        icedrinkB.setProPrice("10");
        icedrink.add(icedrinkB);

        Product icedrinkC = new Product();//现调冰饮C
        icedrinkC.setProName("芒果昔果乐");
        icedrinkC.setProDesc("雀巢昔果乐芒果桃子可乐杯16oz*1");
        icedrinkC.setProImgId(R.drawable.goods5_3);
        icedrinkC.setProPrice("10");
        icedrink.add(icedrinkC);
        totalDatas.put("现调冰饮", icedrink);

        /**
         * 现调热饮集合
         */
        ArrayList<Product> hotdrink = new ArrayList<>();
        Product hotA = new Product();//现调热饮A
        hotA.setProName("雀巢咖啡");
        hotA.setProDesc("雀巢咖啡12oz*1");
        hotA.setProImgId(R.drawable.goods6_1);
        hotA.setProPrice("10");
        hotdrink.add(hotA);

        Product hotB = new Product();//现调热饮B
        hotB.setProName("雀巢奶茶");
        hotB.setProDesc("雀巢奶茶12oz*1");
        hotB.setProImgId(R.drawable.goods6_2);
        hotB.setProPrice("10");
        hotdrink.add(hotB);
        totalDatas.put("现调热饮", hotdrink);

        /**
         * 瓶装饮料集合
         */
        ArrayList<Product> chai = new ArrayList<>();
        Product chaiA = new Product();//瓶装饮料A
        chaiA.setProName("唯他可可椰子水");
        chaiA.setProDesc("唯他可可椰子水饮料 330ml*1");
        chaiA.setProImgId(R.drawable.goods7_1);
        chaiA.setProPrice("15");
        chai.add(chaiA);

        Product chaiB = new Product();//瓶装饮料B
        chaiB.setProName("斐泉矿泉水 330ml");
        chaiB.setProDesc("斐泉矿泉水 330ml*1");
        chaiB.setProImgId(R.drawable.goods7_2);
        chaiB.setProPrice("12");
        chai.add(chaiB);

        Product chaiC = new Product();//瓶装饮料C
        chaiC.setProName("可口可乐瓶装碳酸");
        chaiC.setProDesc("可口可乐瓶装碳酸饮料 500ml;雪碧*1");
        chaiC.setProImgId(R.drawable.goods7_3);
        chaiC.setProPrice("10");
        chai.add(chaiC);

        Product chaiD = new Product();//瓶装饮料D
        chaiD.setProName("可口可乐瓶装水动乐");
        chaiD.setProDesc("可口可乐瓶装水动乐 600ml;柠檬味*1");
        chaiD.setProImgId(R.drawable.goods7_4);
        chaiD.setProPrice("10");
        chai.add(chaiD);

        Product chaiE = new Product();//瓶装饮料E
        chaiE.setProName("可口可乐瓶装碳酸");
        chaiE.setProDesc("可口可乐瓶装碳酸饮料 500ml;怡泉C*1");
        chaiE.setProImgId(R.drawable.goods7_5);
        chaiE.setProPrice("10");
        chai.add(chaiE);

        Product chaiF = new Product();//瓶装饮料F
        chaiF.setProName("可口可乐果粒橙");
        chaiF.setProDesc("可口可乐果粒橙 450ml*1");
        chaiF.setProImgId(R.drawable.goods7_6);
        chaiF.setProPrice("10");
        chai.add(chaiF);

        Product chaiG = new Product();//瓶装饮料G
        chaiG.setProName("5100矿泉水");
        chaiG.setProDesc("5100矿泉水 600ml*1");
        chaiG.setProImgId(R.drawable.goods7_7);
        chaiG.setProPrice("10");
        chai.add(chaiG);
        totalDatas.put("瓶装饮料", chai);

        /**
         * 小食品集合
         */
        ArrayList<Product> snack = new ArrayList<>();
        Product snackA = new Product();//小食品A
        snackA.setProName("农心洋葱圈 70g");
        snackA.setProDesc("农心洋葱圈 70g*1");
        snackA.setProImgId(R.drawable.goods8_1);
        snackA.setProPrice("10");
        snack.add(snackA);

        Product snackB = new Product();//小食品B
        snackB.setProName("农心虾条 90g");
        snackB.setProDesc("农心虾条 90g*1");
        snackB.setProImgId(R.drawable.goods8_2);
        snackB.setProPrice("10");
        snack.add(snackB);
        totalDatas.put("小食品", snack);

        /**
         * 衍生品集合
         */
        ArrayList<Product> derivative = new ArrayList<>();
        Product derivativeA = new Product();//衍生品A
        derivativeA.setProName("妈妈咪鸭飞机书包");
        derivativeA.setProDesc("妈妈咪鸭飞机书包*1");
        derivativeA.setProImgId(R.drawable.goods9_1);
        derivativeA.setProPrice("199");
        derivative.add(derivativeA);

        Product derivativeB = new Product();//衍生品B
        derivativeB.setProName("蜘蛛侠3D背包");
        derivativeB.setProDesc("蜘蛛侠3D背包*1");
        derivativeB.setProImgId(R.drawable.goods9_2);
        derivativeB.setProPrice("89");
        derivative.add(derivativeB);
        totalDatas.put("衍生品", derivative);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);
        //初始化
        initData();
        initView();
    }

    private void initView() {
        tvProNum = findViewById(R.id.number);
        tvPrice = findViewById(R.id.price);
        enter = findViewById(R.id.enter);
        mListView1 = (ListView) findViewById(R.id.list_item_1);
        mListView2 = (ListView) findViewById(R.id.list_item_2);
        adapter1 = new MyListViewAdapter1(mMenus, this, selectIndex);
        adapter2 = new MyListViewAdapter2(products, this);
        mListView1.setAdapter(adapter1);
        mListView2.setAdapter(adapter2);
        mListView2.setOnItemClickListener(this);
        enter.setOnClickListener(this);

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selectIndex = position;
                //左
                adapter1.setIndex(position);
                adapter1.notifyDataSetChanged();
                //右
                products.clear();
                String mMenu = mMenus[selectIndex];
                products.addAll(totalDatas.get(mMenu));
                adapter2.notifyDataSetChanged();
                // 上
                TextView textView = (TextView) findViewById(R.id.list_head);
                textView.setText(mMenu);

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Product product = products.get(position);

        //避免重复 现在取出的product和购物车中的相比较
        boolean isExist=false;
        for (Product product1 : shoppingCar) {
            if(product1.getProName().equals(product.getProName())){
                isExist=true;
                product1.setProNum(product1.getProNum()+1);
                break;
            }
        }
        if(!isExist) shoppingCar.add(product);//加入购物车


        int totalNum = 0,totalPrice=0;
        //  购物车对应数量+1
        for (Product product1 : shoppingCar) {
            totalNum+=product1.getProNum();
            totalPrice+=(product1.getProNum()*Integer.parseInt(product.getProPrice()));
        }

        tvProNum.setText(totalNum+"");
        tvPrice.setText(totalPrice+"");

        bean.setProducts(shoppingCar);
        bean.setTotalNum(totalNum);
        bean.setTotalPrice(totalPrice);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.enter:
                Intent intent=new Intent(Shop.this,shoppingcar.class);
                intent.putExtra("datas",bean);
                startActivityForResult(intent,1001);
                break;
            case R.id.a_car:

                break;
            default:
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1001&&resultCode==2002){
            if(null!=data.getSerializableExtra("datas")){
                bean= (ShoppingCarBean) data.getSerializableExtra("datas");
                //传回购物车内容
                tvProNum.setText(bean.getTotalNum()+"");
                tvPrice.setText(bean.getTotalPrice()+"");
            }

        }
    }
}



