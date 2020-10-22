package com.leniscamila.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.leniscamila.firebasedemo.model.Apunte;
import com.leniscamila.firebasedemo.util.Constants;
import com.leniscamila.firebasedemo.util.HTTPSWebUtilDomi;

import java.util.Date;
import java.util.UUID;

public class ApuntesActivity extends AppCompatActivity implements View.OnClickListener {

    private Button comunidadBtn;
    private Button misApuntesBtn;
    private Button publishBtn;
    private EditText newApunteET;

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuntes);

        comunidadBtn = findViewById(R.id.comunidadBtn);
        misApuntesBtn = findViewById(R.id.misApuntesBtn);
        publishBtn = findViewById(R.id.publishBtn);
        newApunteET = findViewById(R.id.newApunteET);

        username = getIntent().getExtras().getString("username");

        publishBtn.setOnClickListener(this);
        misApuntesBtn.setOnClickListener(this);
        comunidadBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.publishBtn:
                Apunte apunte = new Apunte(UUID.randomUUID().toString(),
                        newApunteET.getText().toString(),
                        new Date().getTime(),
                        username);

                Gson gson = new Gson();
                String json = gson.toJson(apunte);
                HTTPSWebUtilDomi http = new HTTPSWebUtilDomi();
                new Thread(
                        () ->{
                            String response = http.POSTrequest(Constants.BASEURL+"apuntes/"+apunte.getUsername()+
                                    ".json", json);
                            runOnUiThread(() -> Toast.makeText(this, "Publicado",
                                    Toast.LENGTH_LONG).show());
                        }
                )
                .start();
                break;
            case R.id.misApuntesBtn:
                Intent i = new Intent(this, ListaApuntesActivity.class);
                i.putExtra("username", username);
                startActivity(i);
                break;
            case R.id.comunidadBtn:
                Intent intent = new Intent(this, ListaUsuariosActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
                break;

        }
    }
}