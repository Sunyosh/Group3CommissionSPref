package com.example.group3commissionspref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView tvName, tvCNP;
    Button buttonback;
    SharedPreferences sharedPreferences;

    public static final String mypreference = "commissionpref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvName = findViewById(R.id.tvName);
        tvCNP = findViewById(R.id.tvCNP);
        buttonback = findViewById(R.id.buttonback);

        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        String sName = sharedPreferences.getString("NAME", "");
        tvName.setText("Agent Name: " + sName);

        int sCNP = sharedPreferences.getInt("NETPAY", 0);
        tvCNP.setText("Commission Net Pay is: " + sCNP);

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent intent = new Intent(result.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}