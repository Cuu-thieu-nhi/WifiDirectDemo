package com.example.jsoup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String num = "";
//        for (int i = 1; i <= 510; i ++) {
//            if (i < 10) {
//                num = "0000" + String.valueOf(i);
//            } else if (i < 100) {
//                num = "000" + String.valueOf(i);
//            } else {
//                num = "00" + String.valueOf(i);
//            }
//            String url = "https://vietlott.vn/vi/trung-thuong/ket-qua-trung-thuong/max-3D?id=" + num + "&nocatche=1";
//            AsyncTask<String, Void, String> execute = new jsoup().execute(new String[]{url});
//        }
        String url = "https://vietlott.vn/vi/trung-thuong/ket-qua-trung-thuong/max-3D?id=00505&nocatche=1";
        AsyncTask<String, Void, String> execute = new jsoup().execute(new String[]{url});
    }
}