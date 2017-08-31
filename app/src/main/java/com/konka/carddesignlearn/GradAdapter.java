package com.konka.carddesignlearn;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 2017/8/21.
 */

public class GradAdapter extends  RecyclerView.Adapter<GradAdapter.ViewHolder>  {

    private List<String> mData = new ArrayList<>();
   private Context context;

    public GradAdapter( Context context){
        this.context = context;
        mData.add("常见问题");
        mData.add("注册与投资");
        mData.add("兑换领奖");
        mData.add("兑换领奖");
        mData.add("账户安全");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,null,false);
        LinearLayout ly = ((LinearLayout)view.findViewById(R.id.card_ly));
        if(viewType==1){
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 448);
                view.setLayoutParams(p);
            view.setBackgroundResource(R.color.colorAccent );
            ly.setBackgroundResource(R.drawable.card_03);
        }
        GradAdapter.ViewHolder viewHolder = new GradAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(mData.get(position));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        holder.rcView.setLayoutManager(linearLayoutManager);
        RCAdapter rcAdapter = new RCAdapter();
        rcAdapter.setOnItemClickLitener(new RCAdapter.OnItemClickLitener() {
            @Override
            public void onClickLitener(View view, int position) {
                Toast.makeText(context,""+position,Toast.LENGTH_LONG).show();
            }
        });
        holder.rcView.setAdapter(rcAdapter);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0)
            return 1;
        else
            return 2;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
         TextView tv;
         RecyclerView rcView;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.i_tv);
            rcView = (RecyclerView) itemView.findViewById(R.id.rcView);
        }
    }
}
