package com.example.dam_m08_act1;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.StringPrepParseException;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> namesConvertor = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.deSpinner));
        namesConvertor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Añadir al spinner DE los items
        Spinner spinnerDe = (Spinner) findViewById(R.id.spinnerDe);
        spinnerDe.setAdapter(namesConvertor);
    }
}