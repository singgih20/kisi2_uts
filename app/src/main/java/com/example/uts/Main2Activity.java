package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView text_nama, text_jk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String nama = intent.getStringExtra(MainActivity.EXTRA_NAMA);
        String jk = intent.getStringExtra(MainActivity.EXTRA_JK);
        text_nama = findViewById(R.id.text_nama);
        text_jk = findViewById(R.id.text_jk);

        text_nama.setText(nama);
        text_jk.setText(jk);

    }
}
