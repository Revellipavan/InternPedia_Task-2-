package com.example.temperatureconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etInput = findViewById(R.id.et_input);
        RadioGroup rgOptions = findViewById(R.id.rg_options);
        Button btnConvert = findViewById(R.id.btn_convert);
        TextView tvResult = findViewById(R.id.tv_result);

        btnConvert.setOnClickListener(view -> {
            String input = etInput.getText().toString();
            if (!input.isEmpty()) {
                double temp = Double.parseDouble(input);
                Double result = null;

                int selectedId = rgOptions.getCheckedRadioButtonId();
                if (selectedId == R.id.rb_celsius) {
                    result = celsiusToFahrenheit(temp);
                } else if (selectedId == R.id.rb_fahrenheit) {
                    result = fahrenheitToCelsius(temp);
                }

                if (result != null) {
                    tvResult.setText(String.format("%.2f", result));
                } else {
                    tvResult.setText("Please select a conversion option.");
                }
            } else {
                Toast.makeText(this, "Please enter a temperature", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}

