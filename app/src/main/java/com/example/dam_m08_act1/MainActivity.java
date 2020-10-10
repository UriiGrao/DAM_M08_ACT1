package com.example.dam_m08_act1;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.StringPrepParseException;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn;

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

        //Añadir al spinner A los items
        Spinner spinnerA = (Spinner) findViewById(R.id.spinnerA);
        spinnerA.setAdapter(namesConvertor);

        //Accion button
        final TextView resultado = (TextView) findViewById(R.id.result);
        TextView numeroToConvert = (TextView) findViewById(R.id.editTextNumber);
        final String result = numeroToConvert.getText().toString();

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Aplicando conversion...", Toast.LENGTH_LONG).show();
                resultado.setText(result);
            }
        });
    }
}