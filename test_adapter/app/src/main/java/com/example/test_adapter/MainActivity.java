package com.example.test_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] cheeses = {
                "Parmesan",
                "Ricotta",
                "Fontina",
                "Mozzarella",
                "Cheddar"
        };
    }
}