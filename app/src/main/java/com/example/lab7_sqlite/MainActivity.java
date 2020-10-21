package com.example.lab7_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addE = (Button) findViewById(R.id.addE);
        Button updateE = (Button) findViewById(R.id.updateE);
        Button deleteE = (Button) findViewById(R.id.deleteE);
        Button getE = (Button) findViewById(R.id.getE);
        Button getAllE = (Button) findViewById(R.id.getAllE);

        addE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_add_employee.class);
                startActivity(intent);
            }
        });

        updateE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_update_employee.class);
                startActivity(intent);
            }
        });

        deleteE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_delete_employee.class);
                startActivity(intent);
            }
        });

        getE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_get_employee.class);
                startActivity(intent);
            }
        });

        getAllE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_get_all_employees.class);
                startActivity(intent);
            }
        });
    }
}