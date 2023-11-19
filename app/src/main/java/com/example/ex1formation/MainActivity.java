package com.example.ex1formation;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText name,email,passsword,phone,cin;
    private Button sign;
    private String name1,email1,password1,phone1,cin1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        passsword=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        cin=findViewById(R.id.cin);
        sign=findViewById(R.id.signup);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        sign.setOnClickListener(v -> {
            if (validate()) {
                String userEmail=email.getText().toString().trim();
                String userPassword=passsword.getText().toString().trim();
                firebaseAuth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Registration Done!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, SignIn.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show();
            }

        });

    }
    private boolean validate(){
        boolean result=false;
        name1=name.getText().toString();
        email1=email.getText().toString();
        password1=passsword.getText().toString();
        phone1=phone.getText().toString();
        cin1=cin.getText().toString();

        if(name1.isEmpty()|| name1.length()<7) {
            name.setError("Full Name is invalid");
        } else if (email1.isEmpty()|| !email1.contains("@")|| !email1.contains(".")) {
            email.setError("Your Email Address is invalid");
        } else if(phone1.isEmpty()|| phone1.length()!=8) {
            phone.setError("Your phone is invalid");
        } else if (cin1.isEmpty()|| cin1.length()!=8) {
            cin.setError("Your cin is invalid");
        } else if (password1.isEmpty()|| password1.length()<8) {
            passsword.setError("Your password is invalid");
        } else{
            result=true;
        }


        return result;

    }
}