package com.example.bai_2_ung_dung_co_menu_hien_thi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class appsAdapter extends BaseAdapter {

    Context myContext;
    int myLayout;
    List<apps> arrayApps;


    public appsAdapter (Context context, int layout, List<apps> appsList) {
        this.myContext = context;
        this.myLayout = layout;
        this.arrayApps = appsList;
    }

    @Override
    public int getCount() {
        return arrayApps.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayApps.get(i).getPacket();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(myLayout, null);
        TextView namee = (TextView) view.findViewById(R.id.textView1);
        namee.setText(arrayApps.get(i).getName());
        TextView packee = (TextView) view.findViewById(R.id.textView2);
        packee.setText(arrayApps.get(i).getPacket());
        return view;
    }
}
