package com.example.jsoup;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class jsoup extends AsyncTask<String, Void, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        StringBuffer buffer = new StringBuffer();
        try {
            Document document = Jsoup.connect(params[0]).userAgent("chrome").timeout(0).get();
            Elements title = document.select("div.chitietketqua_title");
            for (Element element:title){
                String text = element.text();
                String ky = text.substring(text.indexOf("#", 0), text.indexOf("#", 0) + 6);
                String ngay_thang = text.substring(text.indexOf("/", 0) - 2, text.length());
                buffer.append(ky + ' ' + ngay_thang + " ");
            }
            Elements allEle = document.select("div.day_so_ket_qua_v2");
            for (Element element:allEle){
                String text = element.text();
                buffer.append(text + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s != null){
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream("src/main/assets/ket_qua_xo_so_toan_bo_cac_ky.txt");
                byte b[] = s.getBytes();
                fileOutputStream.write(b);
                fileOutputStream.close();
            } catch (IOException e) {
                Log.d("Tuan", "onPostExecute: loi ghi file");
            }
            Log.d("Tuan", s);
        } else {
            Log.d("Tuan", "loi roi");
        }
    }
}

