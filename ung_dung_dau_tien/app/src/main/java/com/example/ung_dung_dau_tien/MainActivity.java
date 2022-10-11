package com.example.ung_dung_dau_tien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int nam = 2022;
        String hoten = "Đỗ Danh Tuấn";
        Log.d("Đỗ Danh Tuấn", hoten + " " + nam);

        ArrayList<String> arrayName = new ArrayList<>();
        arrayName.add("Ha Noi");
        arrayName.add("Nha Trang");
        arrayName.add("Can Tho");

        Log.d("Tuan", "SIZE = " + arrayName.size());

    }
}