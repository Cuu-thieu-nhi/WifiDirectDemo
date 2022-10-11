package com.example.bai_1_lam_quen_voi_activitiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    int color = Color.argb(255, 255, 0, 0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.viettel);
        tv.setTextColor(color);
    }

    boolean doubleBackToExitPressOne = false;
    @Override
    public void onBackPressed () {
        if (doubleBackToExitPressOne == true) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressOne = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressOne = false;
            }
        }, 2000);
    }

    @Override
    protected void onStop () {
        Random rd = new Random();
        color = Color.argb(255, rd.nextInt(256), rd.nextInt(256), rd.nextInt(256));
//        tv.setTextColor(color);
        super.onStop();
    }

    @Override
    protected void onRestart () {
        tv.setTextColor(color);
        super.onRestart();
    }
}