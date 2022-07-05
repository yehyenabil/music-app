package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    private EditText Name;
    private EditText password;
    private Button add_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        connectdatabasehelper t1 =new connectdatabasehelper(Activity2.this);

        add_user=findViewById(R.id.button);
        Name = findViewById(R.id.editTextTextPersonName);
        password= findViewById(R.id.editTextTextPassword3);

        add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = Name.getText().toString();
                String p = password.getText().toString();
                t1.adduser(n,p);
                Toast.makeText(Activity2.this, n+" successfully created", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}