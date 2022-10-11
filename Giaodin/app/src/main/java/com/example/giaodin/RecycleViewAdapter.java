package com.example.giaodin;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    Context myContext;
    ArrayList<String> myArrayList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ngaythang;
        public ViewHolder (View itemView) {
            super(itemView);
            ngaythang = itemView.findViewById(R.id.tv_ngay_thang);
        }
    }

    public RecycleViewAdapter(Context context, ArrayList<String> arrayList) {
        this.myContext = context;
        this.myArrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context1 = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context1);
        View kqview = layoutInflater.inflate(R.layout.day_result, parent, false);
        ViewHolder viewHolder =  new ViewHolder(kqview);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String t = myArrayList.get(position);
        holder.ngaythang.setText(t);
    }



    @Override
    public int getItemCount() {
        return myArrayList.size();
    }
}
