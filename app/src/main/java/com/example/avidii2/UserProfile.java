package com.example.avidii2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {

    private LinearLayout mSelectedLayout;
    private ImageView mSelectedImage;
    private LinearLayout button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ImageButton backButton = findViewById(R.id.backButtonProfile);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button= findViewById(R.id.profileNext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this,HomeScreen.class);
                startActivity(intent);
            }
        });
    }

    public void onLinearLayoutClicked(View view) {
        if (mSelectedLayout != null && mSelectedImage != null) {
            mSelectedLayout.setSelected(false);
            mSelectedImage.setSelected(false);
        }

        mSelectedLayout = (LinearLayout) view;
        mSelectedImage = (ImageView) mSelectedLayout.findViewWithTag("icon");

        mSelectedLayout.setSelected(true);
        mSelectedImage.setSelected(true);
    }

}
