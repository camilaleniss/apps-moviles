package com.example.semana1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.security.identity.SessionTranscriptMismatchException;
import android.widget.EditText;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    private Button butSubmit;
    private EditText txtProfileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String username = getIntent().getExtras().getString("username");

        butSubmit = findViewById(R.id.butSubmit);
        txtProfileName = findViewById(R.id.txtProfileName);

        txtProfileName.setText(username);

        butSubmit.setOnClickListener(
                (v) -> {
                    Intent data = new Intent();
                    data.putExtra("username", txtProfileName.getText().toString());

                    setResult(RESULT_OK, data);
                    finish();
                }
        );
    }
}