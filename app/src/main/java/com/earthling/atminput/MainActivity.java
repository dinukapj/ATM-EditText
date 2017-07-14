package com.earthling.atminput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    ATMEditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (ATMEditText) findViewById(R.id.etInput);
        etInput.Currency = Currency.SRILANKA;
        etInput.Delimiter = false;
        etInput.Spacing = false;

    }
}
