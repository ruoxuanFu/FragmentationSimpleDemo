package com.example.ruoxuanfu.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruoxuanfu.myapplication.R;
import com.example.ruoxuanfu.myapplication.listener.setOnItemClickListener;

import java.util.List;

/**
 * Created by ruoxuan.fu on 2017/11/1.
 * <p>
 * Code is far away from bug with WOW protecting.
 */

public class ChooseListAdapter extends RecyclerView.Adapter<ChooseListAdapter.MyViewHolder> {

    private List<String> mData;
    private setOnItemClickListener mSetOnItemClickListener;
    private int mHasSelect = -1;

    public ChooseListAdapter(List<String> data) {
        this.mData = data;
    }

    public void setSetOnItemClickListener(setOnItemClickListener setOnItemClickListener) {
        this.mSetOnItemClickListener = setOnItemClickListener;
    }

    public void setHasSelect(int hasSelect) {
        this.mHasSelect = hasSelect;
    }

    @Override
    public ChooseListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_choose_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChooseListAdapter.MyViewHolder holder, final int position) {
        holder.mTvOption.setText(mData.get(position));
        holder.mTvOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mHasSelect != position && mSetOnItemClickListener != null) {
                    mSetOnItemClickListener.setOnClickListener(position);
                }
                mHasSelect = position;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTvOption;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTvOption = itemView.findViewById(R.id.tvOption);
        }
    }
}
