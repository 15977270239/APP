package com.www.app.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.www.app.R;
import com.www.app.enty.Price;
import com.www.app.utils.StringTextUtil;

import java.util.List;

/**
 * Created by Bin on 2016/11/23.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{
   private Activity activity;
    private List<Price> list;
    public MyRecyclerAdapter(Activity activity,List<Price> list){
        this.activity=activity;
        this.list=list;

    }
    //创建itemView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(activity).inflate(R.layout.item_rv_title,parent,false);
        MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }
    //绑定数据到控件上
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String s = list.get(position).getTitle();
        holder.price.setText(StringTextUtil.formatTextNumString(s));
    }
    //条目数量
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView price;

        public MyViewHolder(View itemView) {
            super(itemView);
            if (itemView != null){
                price = (TextView)itemView.findViewById(R.id.price);
            }
        }
    }

}
