package com.example.avidii2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OtpScreen extends AppCompatActivity {

    private TextView tvTimer;
    private CountDownTimer countDownTimer;
    private LinearLayout button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_screen);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button = findViewById(R.id.otp_next);
        EditText editText1 = findViewById(R.id.otp_box_1);
        EditText editText2 = findViewById(R.id.otp_box_2);
        EditText editText3 = findViewById(R.id.otp_box_3);
        EditText editText4 = findViewById(R.id.otp_box_4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtpScreen.this,UserProfile.class);
                startActivity(intent);
            }
        });

        editText1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(editText1.getText().toString().length()==1)     //size as per your requirement
                {
                    editText2.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void afterTextChanged(Editable s) {}
        });
        editText2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(editText2.getText().toString().length()==1)     //size as per your requirement
                {
                    editText3.requestFocus();
                }else{
                    editText1.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void afterTextChanged(Editable s) {}
        });
        editText3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(editText3.getText().toString().length()==1)     //size as per your requirement
                {
                    editText4.requestFocus();
                }else{
                    editText2.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void afterTextChanged(Editable s) {}
        });
        editText4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(editText4.getText().toString().length()!=1)     //size as per your requirement
                {
                    editText3.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void afterTextChanged(Editable s) {}
        });


        tvTimer = findViewById(R.id.tv_timer);

        countDownTimer = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTimer.setText("Didn't receive the code? (0:" + millisUntilFinished / 1000 + ")");
            }

            public void onFinish() {
                tvTimer.setText("Resend code?");
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}