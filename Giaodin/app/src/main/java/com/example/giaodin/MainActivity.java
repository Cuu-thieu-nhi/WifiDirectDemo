package com.example.giaodin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("00/00/2001");
        stringArrayList.add("10/02/2001");
        stringArrayList.add("50/09/2001");
        stringArrayList.add("07/08/2001");
        stringArrayList.add("08/10/2001");
        stringArrayList.add("80/10/2001");
        stringArrayList.add("09/09/2001");
        rv = (RecyclerView) findViewById(R.id.recycle_view);

        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(MainActivity.this, stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rv.setAdapter(recycleViewAdapter);
        rv.setLayoutManager(linearLayoutManager);
        rv.addItemDecoration(new RecycleViewDividerLine(MainActivity.this));
    }
}