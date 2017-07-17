package com.earthling.atminput;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by dinuka on 14/07/2017.
 */

public class ATMEditText extends AppCompatEditText {

    private String current = "";
    private ATMEditText editText = ATMEditText.this;
    public String Currency = "";
    public Boolean Spacing = false;
    public Boolean Delimiter = false;
    public Boolean Decimals = true;

    public ATMEditText(Context context) {
        super(context);
        init();
    }

    public ATMEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ATMEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {

        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().equals(current)) {
                    editText.removeTextChangedListener(this);

                    String cleanString = s.toString().replaceAll("[$,.]", "").replaceAll(Currency, "").replaceAll("\\s+", "");

                    if (cleanString.length() != 0) {
                        try {

                            String currencyFormat = "";
                            if (Spacing) {
                                if (Delimiter) {
                                    currencyFormat = Currency + ". ";
                                } else {
                                    currencyFormat = Currency + " ";
                                }
                            } else {
                                if (Delimiter) {
                                    currencyFormat = Currency + ".";
                                } else {
                                    currencyFormat = Currency;
                                }
                            }

                            double parsed;
                            int parsedInt;
                            String formatted;

                            if (Decimals) {
                                parsed = Double.parseDouble(cleanString);
                                formatted = NumberFormat.getCurrencyInstance().format((parsed / 100)).replace(NumberFormat.getCurrencyInstance().getCurrency().getSymbol(), currencyFormat);
                            } else {
                                parsedInt = Integer.parseInt(cleanString);
                                formatted = currencyFormat + NumberFormat.getNumberInstance(Locale.US).format(parsedInt);
                            }

                            current = formatted;
                            editText.setText(formatted);
                            editText.setSelection(formatted.length());
                        } catch (NumberFormatException e) {

                        }
                    }

                    editText.addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public double getCleanDoubleValue() {
        double value = 0.0;
        if(Decimals){
            value = Double.parseDouble(editText.getText().toString().replaceAll(Currency, ""));
        }
        else{
            String cleanString = editText.getText().toString().replaceAll("[$,.]", "").replaceAll(Currency, "").replaceAll("\\s+", "");
            try {
                value = Double.parseDouble(cleanString);
            } catch (NumberFormatException e) {

            }
        }
        return value;
    }

    public int getCleanIntValue() {
        int value = 0;
        if(Decimals){
            double doubleValue = Double.parseDouble(editText.getText().toString().replaceAll(Currency, ""));
            value = (int) Math.round(doubleValue);
        }
        else{
            String cleanString = editText.getText().toString().replaceAll("[$,.]", "").replaceAll(Currency, "").replaceAll("\\s+", "");
            try {
                value = Integer.parseInt(cleanString);
            } catch (NumberFormatException e) {

            }
        }
        return value;
    }

}
