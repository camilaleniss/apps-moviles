package com.example.ejerciciouno;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button selectBtn;
    private static final int CODE = 0;
    private LinearLayout fondo;
    private String color = "white";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectBtn = findViewById(R.id.selectBtn);
        fondo = findViewById(R.id.fondo);

        selectBtn.setOnClickListener(
                (v) -> {
                    Intent intent = new Intent(this, secondActivity.class);
                    intent.putExtra("color", color);
                    startActivityForResult(intent, CODE);
                }
        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CODE && resultCode == RESULT_OK){
             color = data.getExtras().getString("color");
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
}