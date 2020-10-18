package com.example.dam_m08_act1;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.StringPrepParseException;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
        ArrayAdapter<String> spinnersItems = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinners));
        spinnersItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //SpinnerDe
        final Spinner spinnerFrom = (Spinner) findViewById(R.id.spinnerDe);
        spinnerFrom.setAdapter(spinnersItems);

        //SpinnerA
        final Spinner spinnerTo = (Spinner) findViewById(R.id.spinnerA);
        spinnerTo.setAdapter(spinnersItems);

        //Number to Convert
        final TextView resultado = (TextView) findViewById(R.id.result);
        final EditText numeroToConvert = (EditText) findViewById(R.id.editTextNumber);

        //Action Button
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Aplicando conversion...", Toast.LENGTH_LONG).show();

                double from = converter(spinnerFrom.getSelectedItem().toString());
                double to = converter(spinnerTo.getSelectedItem().toString());

                double number = Double.parseDouble(numeroToConvert.getText().toString());
                double result = (from/to) * number;

                resultado.setText("" + result);
            }
        });

        }

        public double converter(String spinner) {
            double conversion = 1;

            if (spinner.equals("kilobyte")) {
                conversion = 1000;
            } else if (spinner.equals("megabyte")) {
                conversion = 1000000;
            } else if (spinner.equals("gigabyte")) {
                conversion = 1000000000;
            }
            return conversion;
        }
}