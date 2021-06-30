package com.ranzan.validateusercredentialsandperformlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText email;
    private EditText password;
    private TextView forgot;
    private String emailVerify = "[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);
        initValues();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isValidEmail = isValidEmail();
                boolean isValidPassword = isValidPassword();
                if (isValidEmail && isValidPassword) {
                    Intent intent = new Intent(LoginScreen.this, HomeScreen.class);
                    intent.putExtra("email", email.getText().toString());
                    startActivity(intent);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginScreen.this, "Your Message", Toast.LENGTH_LONG).show();

            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginScreen.this, "Your Message", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void initValues() {
        btn1 = findViewById(R.id.btnLogin);
        btn2 = findViewById(R.id.btnSignUp);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        forgot = findViewById(R.id.tvForgot);
    }

    private boolean isValidEmail() {
        if (email.getText().toString().matches(emailVerify)) {
            return true;
        } else {
            email.setError("INVALID EMAIL");
            return false;
        }
    }

    private boolean isValidPassword() {
        if (password.getText().toString().length() >= 6)
            return true;
        else {
            password.setError("Length should be 6");
            return false;
        }
    }
}