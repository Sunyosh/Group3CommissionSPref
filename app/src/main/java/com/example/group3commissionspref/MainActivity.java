package com.example.group3commissionspref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText etName, etRealEstateAmount, etNumberSold, etPercentage, etVAT;
    Button buttoncalculate;

    public static final String mypreference = "commissionpref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etRealEstateAmount = findViewById(R.id.etRealEstateAmount);
        etNumberSold = findViewById(R.id.etNumberSold);
        etPercentage = findViewById(R.id.etPercentage);
        buttoncalculate = findViewById(R.id.buttoncalculate);

        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        buttoncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                int realestateamount = Integer.parseInt(etRealEstateAmount.getText().toString().trim());
                int realestatesold = Integer.parseInt(etNumberSold.getText().toString().trim());
                int percentage = Integer.parseInt(etPercentage.getText().toString().trim());

                double vat = (realestateamount * realestatesold) * 0.1;
                int comnetpay = (int) (((realestateamount * realestatesold) * percentage / 100) - vat);

                SharedPreferences. Editor editor = sharedPreferences.edit();
                editor.putString("NAME", name);
                editor.putInt("REALESTATE", realestateamount);
                editor.putInt("REALESTATESOLD", realestatesold);
                editor.putInt("COMMISSION", percentage);
                editor.putInt("NETPAY", comnetpay);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, result.class);
                startActivity(intent);
                finish();

            }
        });

    }
}