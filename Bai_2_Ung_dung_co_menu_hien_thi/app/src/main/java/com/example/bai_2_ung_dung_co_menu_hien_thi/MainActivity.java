package com.example.bai_2_ung_dung_co_menu_hien_thi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textt = (TextView) findViewById(R.id.main_text);
        textt.setText("Chon menu o goc tren ben phai de lam viec voi ung dung:"
                + "\n 1. Tra cuu thong tin thiet bi" + "\n 2. Tim kiem va truy cap ung dung trong may");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.example_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.devices_specs:
                Toast.makeText(this, "Chon xem thong tin may", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DeviceSpecsActivity.class);
                startActivity(intent);
                break;
            case R.id.apps_find:
                Toast.makeText(this, "Chon tim ung dung", Toast.LENGTH_SHORT).show();
                Intent intents = new Intent(MainActivity.this, FindAppsActivity.class);
                startActivity(intents);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}