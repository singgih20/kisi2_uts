package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText mNama;
    Spinner spinner;
    public static final String EXTRA_NAMA =
            "nama";
    public static final String EXTRA_JK =
            "jk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNama = findViewById(R.id.editText);
        spinner = findViewById(R.id.label_spinner);
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.jenis_kelamin, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerLabel = parent.getItemAtPosition(position).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void sendData(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        String nama = mNama.getText().toString();
        String jenis_kelamin = spinner.getSelectedItem().toString();
        intent.putExtra(EXTRA_NAMA, nama);
        intent.putExtra(EXTRA_JK, jenis_kelamin);
        startActivity(intent);
    }
}
