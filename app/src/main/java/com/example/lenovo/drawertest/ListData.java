package com.example.lenovo.drawertest;
//数据封装bean
public class ListData {
    private int imageview;
    private String nametext;
    private String contentstext;
    public ListData(int imageview,String nametext,String contentstext){
        this.imageview=imageview;
        this.nametext=nametext;
        this.contentstext=contentstext;
    }

    public String getContentstext() {
        return contentstext;
    }

   public int getImageview(){
        return imageview;
   }

    public String getNametext() {
        return nametext;
    }
}
