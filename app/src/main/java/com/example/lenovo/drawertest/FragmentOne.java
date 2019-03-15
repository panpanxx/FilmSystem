package com.example.lenovo.drawertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.example.lenovo.drawertest.ListAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentOne extends Fragment  {
    private Banner mBanner;
    private RecyclerView recyclerView;
    private MyImageLoader mMyImageLoader;
    private ArrayList<Integer> imagePath;
    private ArrayList<String> imageTitle;
    private ListViewForScrollView list;
    private List<ListData> listDatas = new ArrayList<>();
    private ScrollView sv;

    private String[] name = new String[]{ "无双", "找到你", "影", "超能泰坦","李茶的姑妈","胖子行动队"};
    private String[] desc = new String[]{ "大佬强强联合伪造假钞", "姚晨马伊琍互飙演技", "张艺谋回归艺术创作", "神秘外星科幻实验","开心麻花又出手 笑到飙泪有没有","胖子变特工 塞满全世界"};
    private int[] imageId = new int[]{ R.drawable.wushuang , R.drawable.zhaodaoni, R.drawable.ying , R.drawable.chaonengtt,R.drawable.licha,R.drawable.pangzi};
    private String[] grade = new String[]{"9.1","8.7","9.0","6.9","7.7","8.7"};
    private String[] dir = new String[]{"庄文强/周润发/郭富城","吕乐/姚晨/马伊琍","张艺谋/邓超/孙俪","莱纳特·拉夫/萨姆·沃辛顿/泰勒·席琳","吴昱翰/黄才伦/艾伦","包贝尔/文章/郭京飞"};
    private String[] type = new String []{"中国香港/130分钟  动作/犯罪/嫌疑","中国/102分钟  剧情","中国/117分钟  剧情/动作","美国/97分钟  科幻/惊悚","中国/113分钟  剧情/喜剧","中国/115分钟  喜剧/动作"};
    private String[] message = new String []{"剧情简介：以代号“画家”（周润发饰）为首的犯罪团伙，掌握了制造伪钞技术，难辨真伪，并在全球进行交易获取利益，引起警方高度重视。然而“画家”和其他" +
            "成员的身份一直成谜，警方的破案进度遭受到了前所未有的挑战。在关键时刻，擅长绘画的李问（郭富城饰）打开了破案的突破口，而“画家”的真实身份却让众人意想不到…… ",
            "律师李捷（姚晨 饰）正在离婚进行时，与前夫争夺女儿抚养权，拼命工作为给孩子最好的生活，幸有保姆孙芳（马伊琍 饰）帮忙照顾孩子视如己出。 一日下班，李捷发现保姆孙芳和女儿毫无预兆地消失了" +
                    "，她内心最大的恐惧变成了现实。在追寻孙芳和女儿的下落时，她收到来自家人的谴责声讨，甚至遭到警方的怀疑。几乎崩溃的李捷，" +
                    "靠着惊人的勇气，踏上独自寻访的旅 程。在追踪过程中，李捷逐渐接近了另一个女人——保姆孙芳的人生故事，她的身份原先都是谎言，而真相也将浮出水面……",
            "这是一个关于替身的故事。替身自古有之，人称“影子”。有刺杀，就有影子，影子必须在危急关头挺身而出，替主人博回一命；影子又必须与真身互为一体，令旁人真假难辨如同孪生。关于影子的来龙去脉，" +
                    "真身从来忌讳莫深，不愿提及而令真相扑朔迷离......",
            "由于核污染的影响，洛杉矶已经变得不适合人类居住。十年后，地球就将变成一片废墟，人类面临前所未有的挑战。在这个宇宙中，只有一个地方适合人类居住——土星的最大卫星，泰坦。为了移民到泰坦星，一" +
                    "个致力于加速人体进化的实验组成立，萨姆·沃辛顿饰演的军人成为实验对象之一。但这个实验也充满了未知和危险......",
            "《李茶的姑妈》改编自开心麻花同名爆笑舞台剧。李茶（宋阳 饰）是个穷小子，姑妈（卢靖姗 饰）却是全球女首富，自打李茶出生后二人便未曾谋面。为了娶到“势利眼富商”的女儿，李茶恳请姑妈出面牵线搭桥，" +
                    "可各怀鬼胎的一行人却误将男员工黄沧海（黄才伦 饰）认作姑妈。为了各自的利益，黄沧海、李茶连同梁杰瑞（艾伦 饰）三个人将计就计组团来“假扮姑妈”，正当众人纷纷讨好这位“假姑妈”时，神秘的“" +
                    "真姑妈”现身了，一连串的爆笑故事也发生了......",
            "特工“J”（文章 饰）在执行一次A级任务时头部中枪，导致颅内下丘脑受损。养伤期间，J渐渐变成了一个三百斤的大胖子，并患有严重的嗜睡症，但J依然认为自己是一个王牌特工。终于，J再次接到任务，只身前往日本" +
                    "取回机密文件。文件得手后，J却activity_fragment_one擅自拆开文件决定替组织继续完成隐藏其中的任务，不料却晕倒在居酒屋。医院醒来的J结识了保安郝英俊（包贝尔 饰），郝英俊为了证明自己不是个一事无成的废物毅然决然地加入" +
                    "任务中。这对临时拍档在执行任务的过程中，经历一次又一次令人啼笑皆非、险象环生的危机......"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_one,null);
        mBanner=(Banner)view.findViewById(R.id.ban);
        list = (ListViewForScrollView)view.findViewById(R.id.list);
        sv = (ScrollView)view.findViewById(R.id.act_solution_1_sv);
        sv.smoothScrollTo(0, 0);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageId[i]);
            listItem.put("name", name[i]);
            listItem.put("desc", desc[i]);
            listItem.put("grade", grade[i]);
            listItem.put("dir", dir[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), listItems, R.layout.item1, new String[]{"name", "image", "desc", "grade", "dir"},
                new int[]{R.id.list_item_text, R.id.list_item_image, R.id.list_item_text2, R.id.list_item_text4, R.id.list_item_text3});

        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {

                Bundle bundle = new Bundle();
                bundle.putInt("image", imageId[arg2]);
                bundle.putString("name", name[arg2]);
                bundle.putString("type",type[arg2]);
                bundle.putString("message",message[arg2]);
                bundle.putString("dir",dir[arg2]);
                bundle.putString("grade",grade[arg2]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(getActivity(), details.class);
                Log.i("message", message[arg2]);
                Log.i("type",type[arg2]);
                startActivity(intent);
            }
        });


// list.setOnItemSelectedListener(new OnItemSelectedListener() {
//
// @Override
// public void onItemSelected(AdapterView<?> parent, View view,
// int position, long id) {
// // TODO Auto-generated method stub
// Toast.makeText(getActivity(), ""+position+id, Toast.LENGTH_SHORT).show();
//
// }
//
// @Override
// public void onNothingSelected(AdapterView<?> parent) {
// // TODO Auto-generated method stub
//
// }
//
// });
         //设置布局样式线性
        //在此处修改布局排列方向
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //布局添加到recycleview
        recyclerView.setLayoutManager(layoutManager);
        //定义适配器存放数据
        ListAdapter listAdapter = new ListAdapter(listDatas);
        //适配器添加到recycleview
        recyclerView.setAdapter(listAdapter);
       //添加数据
        addingData();
    initData();
        initView();
        return view;
    }


    private void initData() {
        imagePath = new ArrayList<>();
        imageTitle = new ArrayList<>();
        imagePath.add(R.drawable.home_bg4);
        imagePath.add(R.drawable.home_bg3 );
        imagePath.add(R.drawable.home_bg2);
        imagePath.add(R.drawable.home_bg1);
        imagePath.add(R.drawable.home_bg0);
        imageTitle.add("黄金时代：在那个文艺时代");
        imageTitle.add("火锅英雄：一场围绕火锅的奇妙冒险");
        imageTitle.add("结束战争：乱世中追求的和平在何处");
        imageTitle.add("加菲猫：满满都是童年的回忆");
        imageTitle.add("泰坦尼克号：灾难中的传奇爱情");
    }
    private void initView() {
        mMyImageLoader = new MyImageLoader();
        //设置样式，里面有很多种样式可以自己都看看效果
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(mMyImageLoader);
        //设置轮播的动画效果,里面有很多种特效,可以都看看效果。
        mBanner.setBannerAnimation(Transformer.ZoomOutSlide);
        //轮播图片的文字
        mBanner.setBannerTitles(imageTitle);
        //设置轮播间隔时间
        mBanner.setDelayTime(3000);
        //设置是否为自动轮播，默认是true
        mBanner.isAutoPlay(true);
        //设置指示器的位置，小点点，居中显示
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载地址
        mBanner.setImages(imagePath);
        //轮播图的监听

        //开始调用的方法，启动轮播图。
        mBanner .start();

    }
    public void addingData(){
        ListData ace = new ListData(R.drawable.zzx,"蜘蛛侠：平行宇宙", "12月21日");
        listDatas.add(ace);
        ListData arlong = new ListData(R.drawable.lmg,"绿毛怪格林奇", "12月14日");
        listDatas.add(arlong);
        ListData barbe_blanche = new ListData(R.drawable.lm,"龙猫", "12月14日");
        listDatas.add(barbe_blanche);
        ListData d = new ListData(R.drawable.tqyb,"天气预爆", "12月21日");
        listDatas.add(d);
        ListData e = new ListData(R.drawable.stpsl,"神探蒲松龄", "02月05日");
        listDatas.add(e);
        ListData f = new ListData(R.drawable.yw,"叶问外传：张天志", "12月21日");
        listDatas.add(f);
        ListData g = new ListData(R.drawable.ll,"流浪地球", "02月05日");
        listDatas.add(g);
        ListData h = new ListData(R.drawable.zghhr,"中国合伙人2", "12月18日");
        listDatas.add(h);
        ListData k = new ListData(R.drawable.fcrs,"飞驰人生", "02月05日");
        listDatas.add(k);
        ListData s = new ListData(R.drawable.qs,"情圣", "02月05日");
        listDatas.add(s);


    }

   /* public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }*/


    public class MyImageLoader extends ImageLoader {
        //在该方法内用Glide进行加载图片
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }


}




//return inflater.inflate(R.layout.activity_fragment_one, container, false);
// }
//}


