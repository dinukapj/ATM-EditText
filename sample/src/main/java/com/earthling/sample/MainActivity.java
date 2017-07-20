package com.earthling.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.earthling.atminput.ATMEditText;
import com.earthling.atminput.Currency;

public class MainActivity extends AppCompatActivity {

    ATMEditText etInput;
    Button btnProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (ATMEditText) findViewById(R.id.etInput);
        btnProcess = (Button) findViewById(R.id.btnProcess);

        etInput.setCurrency(Currency.MALAYSIA);
        etInput.setDelimiter(false);
        etInput.setSpacing(false);
        etInput.setDecimals(true);
        etInput.setSeparator(".");

        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etInput.length() != 0) {
                    double cleanDoubleOutput = etInput.getCleanDoubleValue();
                    int cleanIntOutput = etInput.getCleanIntValue();

                    Toast.makeText(MainActivity.this, "Clean Double: " + cleanDoubleOutput, Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, "Clean Integer: " + cleanIntOutput, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
