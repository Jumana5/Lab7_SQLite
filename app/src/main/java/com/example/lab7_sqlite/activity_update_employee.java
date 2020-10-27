package com.example.lab7_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class activity_update_employee extends AppCompatActivity {


    EditText empid, empname, empsal;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_employee);

        final EmployeeDBHelper empdb = new EmployeeDBHelper(this);

        empid = (EditText) findViewById(R.id.empidd);
        empname = (EditText) findViewById(R.id.empname);
        empsal = (EditText) findViewById(R.id.empsal);
        update = (Button) findViewById(R.id.btn_update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int emp_id = Integer.parseInt(empid.getText().toString());
                String empstr = empname.getText().toString();
                int intsal = Integer.parseInt(empsal.getText().toString());

                try {
                    if (empdb.updateEmployee(emp_id, empstr, intsal)) {
                        Toast.makeText(getBaseContext(),
                                "Record Has Been Updated", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getBaseContext(),
                                "Record Has Not Been Updated", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(),
                            "Insert All Data, Please !",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        empid.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable e) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                empid.setEnabled(false);
                int emp_id = Integer.parseInt(empid.getText().toString());
                Cursor c = empdb.retrieveEmployee(emp_id);
                try {
                    if (c.moveToFirst()) {
                        empname.setText(c.getString(1));
                        empsal.setText(c.getString(2));
                    } else {
                        Toast.makeText(getBaseContext(),
                                "No Employee Record Found", Toast.LENGTH_SHORT).show();
                    }
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