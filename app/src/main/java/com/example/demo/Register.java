package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText name,emailid,password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        emailid=findViewById(R.id.emailId1);
        password=findViewById(R.id.password1);
        button=findViewById(R.id.confirm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String email = emailid.getText().toString();
                String pass = password.getText().toString();
                if (!Name.isEmpty()&& Name.matches ("^[A-Za-z][A-Za-z0-9_]{7,29}$")  &&!email.isEmpty()
                        && Patterns.EMAIL_ADDRESS.matcher(email).matches() && ( pass.length() >= 6
                        && pass.matches("(.*[0-9].*)")
                        && pass.matches("(.*[A-Z].*)") && pass.matches("^(?=.*[_.()$&@]).*$"))){
                    Intent intent=new Intent(Register.this,MainActivity2.class);
                    Toast.makeText(Register.this, "register successfull", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }else {
                    Toast.makeText(Register.this, "please check email and password and name should not contain punctuation ", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}