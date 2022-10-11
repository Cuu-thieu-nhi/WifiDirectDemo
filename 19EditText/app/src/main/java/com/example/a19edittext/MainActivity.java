package com.example.a19edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editNoiDung;
    Button nut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNoiDung = (EditText) findViewById(R.id.editTextTextPersonName);
        nut = (Button) findViewById(R.id.button);
        nut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noidung = editNoiDung.getText().toString();
                Toast.makeText(MainActivity.this, noidung, Toast.LENGTH_LONG).show();
            }
        });

    }
}