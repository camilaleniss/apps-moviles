package com.example.serializationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName;
    private EditText txtEmail;
    private EditText txtUsername;
    private EditText txtUniversity;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtEmail= findViewById(R.id.txtEmail);
        txtUsername = findViewById(R.id.txtUsername);
        txtUniversity = findViewById(R.id.txtUniversity);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("JSON Serialization", MODE_PRIVATE);
        String json = preferences.getString("tempuser", "NO_OBJT");

        if(!json.equals("NO_OBJT")){
            Gson gson = new Gson();
            Student student = gson.fromJson(json, Student.class);

            txtName.setText(student.getName());
            txtEmail.setText(student.getEmail());
            txtUsername.setText(student.getUsername());
            txtUniversity.setText(student.getUniversity());
        }
    }

    @Override
    protected void onPause() {
        //We will save the json
        String name = txtName.getText().toString();
        String email = txtEmail.getText().toString();
        String username = txtUsername.getText().toString();
        String university = txtUniversity.getText().toString();

        Student student = new Student(name, email, username, university);

        //Serialize in a Json
        Gson gson = new Gson();
        String json= gson.toJson(student);

        Toast.makeText(this, json, Toast.LENGTH_LONG).show();
        Log.e(">>>>>>>", json);

        //LocalStorage = SharedPreferences

        SharedPreferences preferences = getSharedPreferences("JSON Serialization", MODE_PRIVATE);
        preferences.edit().putString("tempuser", json).apply();


        super.onPause();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnRegister:


                break;
        }
    }
}