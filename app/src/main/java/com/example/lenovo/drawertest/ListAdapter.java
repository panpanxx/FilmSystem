package com.example.lenovo.drawertest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListData> mDataList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageAvatar;
        TextView nameText;
        TextView contentsText;
        public ViewHolder(View itemView) {
            super(itemView);
            imageAvatar = (ImageView)itemView.findViewById(R.id.horizontalImageView);
            nameText =(TextView) itemView.findViewById(R.id.horizontalTextViewName);
            contentsText = (TextView)itemView.findViewById(R.id.horizontalTextViewContent);

        }
    }
    //数据传到适配器中
    public  ListAdapter(List<ListData> listDatas){
        mDataList = listDatas;
    }

//绑定对应的布局
    //为Viewholder赋予一个xml界面
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1b,
                parent,false);
        ViewHolder holder = new ViewHolder(view);
        //返回获取到的布局
        return holder;
    }
//获取每个数据
    //用来给控件赋值
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListData listData = mDataList.get(position);
        holder.imageAvatar.setImageResource(listData.getImageview());
        holder.nameText.setText(listData.getNametext());
        holder.contentsText.setText(listData.getContentstext());
    }
//item的数量
    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
