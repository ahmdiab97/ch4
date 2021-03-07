package com.example.ch4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double conversionRate=2.2;
    double convertedWeight;
    double weightEntered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_accessibility_new);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText weight= (EditText)findViewById(R.id.editTextNumber);
        final RadioButton r1=(RadioButton)findViewById(R.id.radioButton);
        final RadioButton r2=(RadioButton)findViewById(R.id.radioButton2);
        final TextView result=(TextView)findViewById(R.id.textView2);
        Button bttn =(Button)findViewById(R.id.button);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat dec = new DecimalFormat("$#.#");
                if (r1.isChecked()) {
                    if (weightEntered <= 500) {
                        convertedWeight = weightEntered / conversionRate;
                        result.setText(dec.format(convertedWeight) + " Kilograms");
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Pounds Must be less than 500",Toast.LENGTH_LONG).show();
                    }
                    if (r2.isChecked()) {
                        if(weightEntered<=500) {
                            convertedWeight = weightEntered * conversionRate;
                            result.setText(dec.format(convertedWeight) + " Pounds");
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Kiograms Must be less than 500",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

    }
}