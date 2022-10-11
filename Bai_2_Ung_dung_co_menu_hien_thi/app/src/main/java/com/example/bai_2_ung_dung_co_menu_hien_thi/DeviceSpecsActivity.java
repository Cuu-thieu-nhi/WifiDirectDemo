package com.example.bai_2_ung_dung_co_menu_hien_thi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DeviceSpecsActivity extends AppCompatActivity {

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
                break;
            case R.id.apps_find:
                Toast.makeText(this, "Chon tim ung dung", Toast.LENGTH_SHORT).show();
                Intent intents = new Intent(DeviceSpecsActivity.this, FindAppsActivity.class);
                startActivity(intents);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    TextView type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_specs);

        type = (TextView) findViewById(R.id.device_type);
        String s="Device infos: \n";
        s += "\nOS Version: " + System.getProperty("os.version");
        s += "\nDevice name: " + Build.MANUFACTURER + " " + Build.PRODUCT;
        s += "\nDevice type: " + Build.TYPE;
        type.setText(s);

    }
}