package com.example.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ViewCourses extends AppCompatActivity {
    private ArrayList<Coursemodel> courseModalArrayList;
    private DBHandler dbHandler;
    private final static int MY_REQUEST_CODE=1;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private CourseRVAdapter courseRVAdapter;
    private RecyclerView coursesRV;
    FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_courses);
        button=findViewById(R.id.Add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ViewCourses.this,MainActivity2.class);
               startActivityForResult(intent,MY_REQUEST_CODE);
            }
        });

        preferences = getSharedPreferences("My preferences", MODE_PRIVATE);
        editor = preferences.edit();

        courseModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewCourses.this);
        courseModalArrayList = dbHandler.readCourses();


        courseRVAdapter = new CourseRVAdapter(courseModalArrayList, ViewCourses.this);
        coursesRV = findViewById(R.id.idRVCourses);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCourses.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);


        coursesRV.setAdapter(courseRVAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            if (resultCode==MainActivity2.RESULT_OK){
                if (data!=null)
                courseModalArrayList = new ArrayList<>();
                dbHandler = new DBHandler(ViewCourses.this);
                courseModalArrayList = dbHandler.readCourses();
                courseRVAdapter = new CourseRVAdapter(courseModalArrayList, ViewCourses.this);
                coursesRV = findViewById(R.id.idRVCourses);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCourses.this, RecyclerView.VERTICAL, false);
                coursesRV.setLayoutManager(linearLayoutManager);
                coursesRV.setAdapter(courseRVAdapter);

            }
        }
        if (requestCode==2){
            if (resultCode==UpdateCourseActivity.RESULT_OK){
                if (data!=null)
                    courseModalArrayList = new ArrayList<>();
                dbHandler = new DBHandler(ViewCourses.this);
                courseModalArrayList = dbHandler.readCourses();
                courseRVAdapter = new CourseRVAdapter(courseModalArrayList, ViewCourses.this);
                coursesRV = findViewById(R.id.idRVCourses);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCourses.this, RecyclerView.VERTICAL, false);
                coursesRV.setLayoutManager(linearLayoutManager);
                coursesRV.setAdapter(courseRVAdapter);
            }
        }
        if (requestCode==3){
            if (resultCode==UpdateCourseActivity.RESULT_OK){
                if (data!=null)
                    courseModalArrayList = new ArrayList<>();
                dbHandler = new DBHandler(ViewCourses.this);
                courseModalArrayList = dbHandler.readCourses();
                courseRVAdapter = new CourseRVAdapter(courseModalArrayList, ViewCourses.this);
                coursesRV = findViewById(R.id.idRVCourses);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCourses.this, RecyclerView.VERTICAL, false);
                coursesRV.setLayoutManager(linearLayoutManager);
                coursesRV.setAdapter(courseRVAdapter);

            }
        }
    }
}