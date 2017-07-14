# ATM-EditText
A Custom EditText implementation that allows formatting of currency-based numeric inputs Edit Add topics.

## Usage

```
compile 'com.github.dinukapj:ATM-EditText:1.0'
```

## Implementation Sample

```
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
```

## Customizing

The following attributes can be manipulated:

- Currency by specifying the country
- Spacing between currency and value
- Delimeter

### Currency

Specify the currency by setting the country of your choice.

```
etInput.Currency = Currency.MALAYSIA;
```

#### Custom Currency/Symbol

If a custom symbol that is not included in the library is required, any string value can be used since the the `Currency` attribute expects a `String` value.

```
etInput.Currency = "TEST";
```

Which produces:
>TEST 450.00

**Note:** Currency is `$` (US Dollar) by default.

### Spacing

The spacing between the currency and the value can be specified by:

```
etInput.Spacing = true;
```

**Note:** Spacing is `false` by default.

### Delimeter

The delimeter attribute allows the addition of a `.` symbol after displaying the currency.

> Rs.100

> Rp.100

**Note:** Delimeter is `false` by default.
