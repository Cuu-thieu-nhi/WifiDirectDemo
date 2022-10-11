package com.example.bai_2_ung_dung_co_menu_hien_thi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;




public class FindAppsActivity extends AppCompatActivity{

    ListView lv;
    SearchView search;
    ArrayList<apps> arrayApp;


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
                Intent intents = new Intent(FindAppsActivity.this, DeviceSpecsActivity.class);
                startActivity(intents);
                break;
            case R.id.apps_find:
                Toast.makeText(this, "Chon tim ung dung", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public String getNameFromPacket (String s) {
        String res = "";
        for (int i = s.length() - 1; i >= 0; i --) {
            if (s.charAt(i) == '.') {
                break;
            }
            res += s.charAt(i);
        }
        StringBuilder input1 = new StringBuilder();
        input1.append(res);
        input1.reverse();
        return input1.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_apps);

        lv = (ListView) findViewById(R.id.listView);
        search = (SearchView) findViewById(R.id.searchView);
        arrayApp = new ArrayList<apps>();


        final PackageManager pm = getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo packageInfo : packages) {
            String tmp = packageInfo.packageName.toString();
            String tmp1 = getNameFromPacket(tmp);
            apps xxx = new apps(tmp1, tmp);
            arrayApp.add(xxx);
        }

        appsAdapter adapter = new appsAdapter(FindAppsActivity.this, R.layout.custom_list_view, arrayApp);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(lv.getItemAtPosition(i).toString());
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }

            }
        });

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<apps> temppp = new ArrayList<apps>();
                if (s.length() != 0) {
                    for (apps i:arrayApp) {
                        if (i.getName().contains(s) || i.getPacket().contains(s)) {
                            temppp.add(i);
                        }
                    }
                }
                appsAdapter adapter = new appsAdapter(FindAppsActivity.this, R.layout.custom_list_view, temppp);
                lv.setAdapter(adapter);
                return false;
            }
        });








    }


}