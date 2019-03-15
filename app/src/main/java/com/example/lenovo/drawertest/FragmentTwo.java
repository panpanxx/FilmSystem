package com.example.lenovo.drawertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentTwo extends Fragment {
    private ListView list;
    private String[] desc = new String[]{"天气预报 转出好礼乐翻天", "格林奇与龙猫，相遇刮刮奖",
            "【第一期】疯狂爆灯 纷享萌力", "IMAX超值观影月", "60秒成为电影大富翁",
            "IMAX升舱日 每周三29元起", "招商银行万达电影联名信用卡标准版", "全年签到享好礼"};
    private int[] imageId = new int[]{R.drawable.activity1, R.drawable.activity2,
            R.drawable.activity3, R.drawable.activity4, R.drawable.activity5, R.drawable.activity6,
            R.drawable.activity7, R.drawable.activity8};
    private int[] imageContent = new int[]{R.drawable.contentb, R.drawable.contentc,
            R.drawable.contentb, R.drawable.activity_content4, R.drawable.activity_content5,
            R.drawable.activity_content6, R.drawable.activity_content7, R.drawable.activity_content8};
    private String[] time = new String[]{"仅剩10天", "仅剩6天", "14天后结束", "13天后结束",
            "仅剩8天", "仅剩9天", "93天后结束", "14天后结束"};
    private String[] attention = new String[]{"14170人关注", "38550人关注", "38623人关注", "171432人关注",
            "31842人关注", "86614人关注", "232065人关注", "2122997人关注"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_two, null);
        list = (ListView) view.findViewById(R.id.list2);
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < desc.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageId[i]);
            listItem.put("desc", desc[i]);
            listItem.put("time", time[i]);
            listItem.put("attention", attention[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), listItems, R.layout.item2, new String[]{"image", "desc", "time", "attention"},
                new int[]{R.id.list_item_image1, R.id.text1, R.id.textView2, R.id.textView3});

        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Bundle bundle = new Bundle();
                bundle.putInt("content", imageContent[arg2]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(getActivity(), content.class);
                startActivity(intent);
            }
        });
        return view;
    }
}