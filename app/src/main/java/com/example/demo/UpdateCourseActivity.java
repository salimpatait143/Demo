package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateCourseActivity extends AppCompatActivity {
    private EditText NameEdt, DesignEdt, DepartEdt;
    private Button updateBtn,deletebtn;
    private DBHandler dbHandler;
    String Name, Design, Depart,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course);
        NameEdt = findViewById(R.id.idEdtName);
        DesignEdt = findViewById(R.id.idEdtDesign);
        DepartEdt = findViewById(R.id.idEdtDepart);
        updateBtn = findViewById(R.id.idBtnUpdateCourse);
        deletebtn=findViewById(R.id.delete);


        dbHandler = new DBHandler(UpdateCourseActivity.this);


        Name = getIntent().getStringExtra("empName");
        Depart = getIntent().getStringExtra("empDepart");
        Design = getIntent().getStringExtra("empDesign");
        id = getIntent().getStringExtra("id");

        NameEdt.setText(Name);
        DesignEdt.setText(Design);
        DepartEdt.setText(Depart);
//        Idedt.setText(id);


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dbHandler.updateCourse(id,NameEdt.getText().toString(),
                        DesignEdt.getText().toString(), DepartEdt.getText().toString());
                setResult(RESULT_OK);
                finish();
                Toast.makeText(UpdateCourseActivity.this, "Table  Updated..", Toast.LENGTH_SHORT).show();


//                Intent i = new Intent(UpdateCourseActivity.this, MainActivity2.class);
//                startActivity(i);
            }
        });
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler.Delete(id);
                Toast.makeText(UpdateCourseActivity.this, "successfully deleted", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}