package com.example.myapplicationcd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String[] items = {"Parmesan",
            "Ricotta",
            "Fontina",
            "Mozzarella",
            "Cheddar"   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ListView myListView = findViewById(R.id.my_listview);
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        myListView.setAdapter(myArrayAdapter);

    }
}