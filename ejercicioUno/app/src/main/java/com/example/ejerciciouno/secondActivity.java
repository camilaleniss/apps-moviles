package com.example.ejerciciouno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class secondActivity extends AppCompatActivity {

    private Button whiteBtn;
    private Button blueBtn;
    private Button blackBtn;
    private LinearLayout fondo;
    private String color = "white";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        whiteBtn = findViewById(R.id.whiteBtn);
        blueBtn = findViewById(R.id.blueBtn);
        blackBtn = findViewById(R.id.blackBtn);

        color = getIntent().getExtras().getString("color");

        whiteBtn.setOnClickListener(
                (v) -> {
                    Intent data = new Intent();
                    data.putExtra("color", "blanco");
                    setResult(RESULT_OK, data);
                    finish();
                }
        );

        blueBtn.setOnClickListener(
                (v) -> {
                    Intent data = new Intent();
                    data.putExtra("color", "azul");
                    setResult(RESULT_OK, data);
                    finish();
                }
        );

        blackBtn.setOnClickListener(
                (v) -> {
                    Intent data = new Intent();
                    data.putExtra("color", "negro");
                    setResult(RESULT_OK, data);
                    finish();
                }
        );

        if(color.equals("blanco")){
            fondo.setBackgroundColor(Color.WHITE);
        }

        if(color.equals("azul")){
            fondo.setBackgroundColor(Color.BLUE);
        }

        if(color.equals("negro")){
            fondo.setBackgroundColor(Color.BLACK);
        }
    }
}