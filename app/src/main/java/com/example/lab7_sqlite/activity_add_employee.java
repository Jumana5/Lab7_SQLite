package com.example.lab7_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_add_employee extends AppCompatActivity {

    Button add_emp;
    EditText empname, empsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        final EmployeeDBHelper empdbhelper = new EmployeeDBHelper(this);
        empname = (EditText) findViewById(R.id.empname);
        empsal = (EditText) findViewById(R.id.empsal);
        add_emp = (Button) findViewById(R.id.btn_update);

        add_emp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                try {
                    String name;
                    int sal;
                    name = empname.getText().toString();
                    sal = (Integer.parseInt(empsal.getText().toString()));
                    empdbhelper.insertEmployee(name, sal);
                    Toast.makeText(getBaseContext(),
                            "Your Record Has Been Saved Successfully !!",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(),
                            "Insert All Data, Please !",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}