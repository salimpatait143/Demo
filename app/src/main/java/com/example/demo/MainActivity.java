package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText emailId;
    private EditText password;
    Button mButton, signup;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("My preferences", MODE_PRIVATE);
        editor = preferences.edit();
        if (preferences.contains("saved email")) {
            Intent intent=new Intent(MainActivity.this,ViewCourses.class);
            startActivity(intent);

        } else {
            signup = findViewById(R.id.register);
            mButton = findViewById(R.id.confirm);
            password = findViewById(R.id.password);
            emailId = findViewById(R.id.emailId);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "please sign in", Toast.LENGTH_SHORT).show();
                    String email = emailId.getText().toString();
                    String pass = password.getText().toString();
                    editor.putString("saved email", email);
                    editor.putString("saved pass", pass);
                    editor.commit();
                    if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches() && (pass.length() >= 6 && pass.matches("(.*[0-9].*)")
                            && pass.matches("(.*[A-Z].*)") && pass.matches("^(?=.*[_.()$&@]).*$"))) {
                        Toast.makeText(MainActivity.this, "Email and Password valid", Toast.LENGTH_SHORT).show();
//                        SharedPreferences preferences = getSharedPreferences("confirm", MODE_PRIVATE);
//                        SharedPreferences.Editor editor = preferences.edit();
//                        editor.putBoolean("mButton", true);
//                        editor.apply();
                        Intent intent = new Intent(MainActivity.this, ViewCourses.class);
                        startActivity(intent);
                    } else {
//                    SharedPreferences preferences=getSharedPreferences("confirm",MODE_PRIVATE);
//                    SharedPreferences.Editor editor=preferences.edit();
//                    editor.putBoolean("mButton",false);
//                    editor.apply();
                        Toast.makeText(MainActivity.this, "Email OR Password invalid", Toast.LENGTH_SHORT).show();
                    }

                }

            });
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Register.class);
                    startActivity(intent);
                }
            });


        }
    }
}