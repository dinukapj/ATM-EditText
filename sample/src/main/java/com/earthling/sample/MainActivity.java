package com.earthling.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.earthling.atminput.ATMEditText;
import com.earthling.atminput.Currency;

public class MainActivity extends AppCompatActivity {

    ATMEditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (ATMEditText) findViewById(R.id.etInput);

        etInput.Currency = Currency.MALAYSIA;
        etInput.Delimiter = false;
        etInput.Spacing = false;
        etInput.Decimals = false;

    }
}
