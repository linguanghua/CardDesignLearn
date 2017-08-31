package com.konka.mvplearn.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.konka.mvplearn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linxu on 2017/8/31.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<String> list = new ArrayList<>();

    public MainAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        public TextView tv;
        public MainViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_tv);
        }
        public void setData(String data){
            tv.setText(data);
        }
    }
}
