package com.example.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "employed";


    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "myemployee";


    private static final String ID_COL = "id";


    public static final String NAME_COL = "name";


    private static final String DESIGNATION = "designation";


//    private static final String DESCRIPTION_COL = "description";

    private static final String DEPARTMENT = "department";
    private static final String TAG = "TAG";


    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME_COL + " TEXT,"
                + DESIGNATION + " TEXT,"
                + DEPARTMENT + " TEXT)";


        db.execSQL(query);
    }
    private boolean isValueExist(String value){
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + DESIGNATION + " = ?";
        String[] whereArgs = {value};

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, whereArgs);

        int count = cursor.getCount();

        cursor.close();

        return count >= 1;
    }

    public boolean addNewCourse(String empName, String designation, String department) {
        if (!isValueExist(designation)) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(NAME_COL, empName);
            cv.put(DESIGNATION, designation);
            cv.put(DEPARTMENT, department);

           long result= db.insert(TABLE_NAME, null, cv);
           return result!=-1;
        }else {
            return false;
        }
    }
//

    public ArrayList<Coursemodel> readCourses() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorEmployee = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        
        ArrayList<Coursemodel> courseModalArrayList = new ArrayList<>();

        if (cursorEmployee.moveToFirst()) {
            do {
                courseModalArrayList.add(new Coursemodel(cursorEmployee.getString(0),
                        cursorEmployee.getString(1),
                        cursorEmployee.getString(2),
                        cursorEmployee.getString(3)));
            } while (cursorEmployee.moveToNext());
        }

        cursorEmployee.close();
        return courseModalArrayList;
    }
    public void updateCourse(String name,String empName,
                             String department, String designation) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, empName);
        values.put(DESIGNATION, designation);
        values.put(DEPARTMENT, department);

        db.update(TABLE_NAME, values, "id=?", new String[]{name});
        db.close();
    }

    public void Delete(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,"id=?",new String[]{name});
        close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    }
