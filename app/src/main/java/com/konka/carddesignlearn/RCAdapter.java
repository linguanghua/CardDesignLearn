package com.konka.carddesignlearn;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 2017/8/21.
 */

public class RCAdapter extends RecyclerView.Adapter<RCAdapter.ViewHolder> {

    private List<String> mData = new ArrayList<>();


    public RCAdapter(){
        for (int i = 0; i <5 ; i++) {
            mData.add("aaaaa");
        }
    }
    public RCAdapter(List<String> mData){
      this.mData = mData;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item,null,false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setFocusable(true);
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    view.setBackgroundResource(R.drawable.shape_tv_item);
                }else{
                    view.setBackgroundResource(R.drawable.help_item_click);
                }
            }
        });

        if(mOnItemClickLitener!=null) {
           view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

       holder.rc_tv.setText(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView rc_tv;
        public ViewHolder(View itemView) {
                super(itemView);
            rc_tv = (TextView) itemView.findViewById(R.id.rc_tv);
        }
    }

    public interface OnItemClickLitener{
        void onClickLitener(View view,int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener){
        this.mOnItemClickLitener = mOnItemClickLitener;
    }



}
