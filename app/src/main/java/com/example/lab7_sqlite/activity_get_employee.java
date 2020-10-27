package com.example.lab7_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_get_employee extends AppCompatActivity {

    Button find_emp;
    EditText empid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_employee);

        final EmployeeDBHelper empdb = new EmployeeDBHelper(this);

        empid = (EditText) findViewById(R.id.empid);
        find_emp = (Button) findViewById(R.id.btn_find);

        find_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int emp_id = Integer.parseInt(empid.getText().toString());
                Cursor c = empdb.retrieveEmployee(emp_id);
                if (c.moveToFirst()) {
                    Toast.makeText(getBaseContext(),
                            "Employee Id: " + c.getString(0)
                                    + "\n Employee Name: " + c.getString(1)
                                    + " \n Employee Salary: " + c.getString(2)
                            , Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "No Employee Record Found",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}