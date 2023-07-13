package com.example.ex1formation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Forget extends AppCompatActivity {
private FloatingActionButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        back=findViewById(R.id.back);

        back.setOnClickListener(v -> {
            startActivity(new Intent(Forget.this, SignIn.class));
        });
    }
}