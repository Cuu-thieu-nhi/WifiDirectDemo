package com.example.testjsoup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String siteUrl = "https://vietlott.vn/vi/trung-thuong/ket-qua-trung-thuong/max-3D?id=00509&nocatche=1";
        new ParseUrl().execute(new String[]{siteUrl});
    }

    public class ParseUrl extends AsyncTask<String, Void, String > {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                Document document = Jsoup.connect(strings[0]).get();
                String title = document.title();
                Log.d("Tuan", title);
                stringBuffer.append("Title:" + title + "\r\n");



                Element table = document.getElementById("divMax3D");
                Elements row = table.getElementsByTag("tr");
                for (Element t : row) {
                    String trrrr = t.text();
                    Log.d("Tuan", trrrr);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuffer.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                Log.d("Tuan", s);
            } else {
                Log.d("Tuan", "err");
            }
        }
    }
}