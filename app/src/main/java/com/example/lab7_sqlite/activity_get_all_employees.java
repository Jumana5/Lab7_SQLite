package com.example.lab7_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class activity_get_all_employees extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_employees);

        final EmployeeDBHelper emphelper = new EmployeeDBHelper(this);
        Cursor c = emphelper.retrieveAllEmployees();

        if(c.moveToFirst())
        {
            do{
                Toast.makeText(this,
                        "Employee Id:" + c.getString(0) + "\n"
                                + "Employee Name:" + c.getString(1) + "\n"
                                + "Employee Salary:" + c.getString(2),
                        Toast.LENGTH_LONG).show();
            } while(c.moveToNext());
        } else {
            Toast.makeText(this,
                    "No Records In The Database",Toast.LENGTH_LONG).show();
        }
    }
}