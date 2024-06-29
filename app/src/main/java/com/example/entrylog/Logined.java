package com.example.entrylog;

import android.content.Intent;
import android.content.SharedPreferences;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Logined extends AppCompatActivity {
    EditText se1,se2,se3,se4;
    AppCompatButton sb1,sb2;
    String apiurl="http://10.0.4.16:3000/api/students";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logined);
        se1=(EditText) findViewById(R.id.sname);
        se2=(EditText) findViewById(R.id.saddno);
        se3=(EditText) findViewById(R.id.sdepname);
        se4=(EditText) findViewById(R.id.ssysno);
        sb1=(AppCompatButton) findViewById(R.id.slog);
        sb2=(AppCompatButton) findViewById(R.id.sback);
        sb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        SharedPreferences preferences=getSharedPreferences("logapp",MODE_PRIVATE);
                        SharedPreferences.Editor editor= preferences.edit();
                        editor.clear();
                        editor.apply();
                        Intent i=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
            }
        });
        sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //value reading
                String getname=se1.getText().toString();
                String getadmissionno=se2.getText().toString();
                String getdepname=se3.getText().toString();
                String getsystemno=se4.getText().toString();

                //json object creation
                JSONObject student=new JSONObject();
                try {
                    student.put("name",getname);
                    student.put("admission_number",getadmissionno);
                    student.put("system_number",getdepname);
                    student.put("department",getsystemno);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                //JSON Object request creation
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                        Request.Method.POST,
                        apiurl,
                        student,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_SHORT).show();
                            }
                        }
                );
                //Request Queue
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);



            }
        });


    }
}