package com.example.avidii2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.hbb20.CountryCodePicker;

public class MobileLogin extends AppCompatActivity {

    CountryCodePicker ccp;
    EditText editText;
    LinearLayout button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_login);

        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        editText = (EditText) findViewById(R.id.editText);
        button = findViewById(R.id.phoneNumberNext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(MobileLogin.this,OtpScreen.class);
            startActivity(intent);
            }
        });
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ccp.registerCarrierNumberEditText(editText);
    }



}