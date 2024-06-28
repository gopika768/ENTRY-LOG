package com.example.entrylog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Logined extends AppCompatActivity {
    EditText se1,se2,se3;
    AppCompatButton sb1,sb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logined);
        se1=(EditText) findViewById(R.id.sname);
        se2=(EditText) findViewById(R.id.saddno);
        se3=(EditText) findViewById(R.id.ssysno);
        sb1=(AppCompatButton) findViewById(R.id.slog);
        sb2=(AppCompatButton) findViewById(R.id.sback);
        sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getname=se1.getText().toString();
                String getadmmissionno=se2.getText().toString();
                String getsystemno=se3.getText().toString();
                Toast.makeText(getApplicationContext(),getname+" "+getadmmissionno+" "+getsystemno,Toast.LENGTH_SHORT).show();
            }
        });
        sb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}