package com.example.lenovo.drawertest;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

//商品实体类
public class Product implements Serializable{

    private String proName;
    private String proDesc;
    private String proPrice;
    private int proImgId;
    private int proNum;
    private boolean isExist;



    public Product(){
        this.proNum=1;
    }

    public void setProDesc(String proDesc){
        this.proDesc=proDesc;
    }
    public String getProDesc(){
        return this.proDesc;
    }


    public void setProName(String proName) { this.proName = proName; }
    public String getProName() { return proName; }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }
    public String getProPrice() {
        return proPrice;
    }

    public void setProImgId(int proImgId) { this.proImgId = proImgId; }
    public int getProImgId() { return proImgId; }

    public void setProNum(int proNum) { this.proNum = proNum; }
    public int getProNum() { return proNum; }


    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }
}
