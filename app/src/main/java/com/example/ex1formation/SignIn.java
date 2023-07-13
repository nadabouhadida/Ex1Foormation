package com.example.ex1formation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {
private TextView forget,sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        forget=findViewById(R.id.forget);
        sign=findViewById(R.id.account);

        forget.setOnClickListener(v -> {
            startActivity(new Intent(SignIn.this, Forget.class));
        });

        sign.setOnClickListener(v -> {
            startActivity(new Intent(SignIn.this, MainActivity.class));
        });



    }
}