 package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


 public class MainActivity extends AppCompatActivity {

     private EditText Name;
     private EditText password;
     private Button Login;
     private Button register;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectdatabasehelper t1 =new connectdatabasehelper(MainActivity.this);

        Login=findViewById(R.id.button);
        Name = findViewById(R.id.editTextTextPersonName);
        password= findViewById(R.id.editTextTextPassword3);
        register =findViewById(R.id.regiester);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(view -> {
            String n = Name.getText().toString();
            String p = password.getText().toString();
            Cursor cursor = t1.search(n,p);
            if (cursor.getCount()==0){
                Toast.makeText(MainActivity.this, "invalid password", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }

        });



    }


}