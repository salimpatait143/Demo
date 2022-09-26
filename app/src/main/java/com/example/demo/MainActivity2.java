package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity2 extends AppCompatActivity {
    private EditText employeeNameEdt, designationEdt, departmentEdt;
    private Button addemployeeBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        employeeNameEdt = findViewById(R.id.idEdtName);
        designationEdt = findViewById(R.id.idEdtDesignation);
        departmentEdt = findViewById(R.id.idEdtDepartment);
        addemployeeBtn = findViewById(R.id.idBtnAddCourse);
//        id=findViewById(R.id.idEdtid);


        dbHandler = new DBHandler(MainActivity2.this);


        addemployeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String employeeName = employeeNameEdt.getText().toString();
                String design = designationEdt.getText().toString();
                String depart = departmentEdt.getText().toString();

                if (employeeName.isEmpty() && design.isEmpty() && depart.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
             boolean exist= dbHandler.addNewCourse(employeeName, depart, design);
                if (exist){
                    Toast.makeText(MainActivity2.this, "details added", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity2.this, "Already Exist", Toast.LENGTH_SHORT).show();
                    return;
                }
//                String name= employeeNameEdt.getText().toString().trim();
//                Intent intent=new Intent();
//                intent.putExtra("key",name);
                setResult(RESULT_OK);
                finish();
                employeeNameEdt.setText("");
                departmentEdt.setText("");
                designationEdt.setText("");

            }
        });
    }
}