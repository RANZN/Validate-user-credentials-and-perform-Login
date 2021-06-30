package com.ranzan.validateusercredentialsandperformlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        email = findViewById(R.id.email);
        Intent intent = getIntent();
        String emailShow = intent.getStringExtra("email");
        email.setText(emailShow);
    }
}