package com.leniscamila.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.leniscamila.firebasedemo.model.Apunte;
import com.leniscamila.firebasedemo.util.Constants;
import com.leniscamila.firebasedemo.util.HTTPSWebUtilDomi;

import java.lang.reflect.Type;
import java.util.HashMap;

public class ListaApuntesActivity extends AppCompatActivity {

    private TextView apuntesTitle;
    private TextView apuntesTV;

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_apuntes);

        apuntesTitle = findViewById(R.id.apuntesTitle);
        apuntesTV = findViewById(R.id.apuntesTV);

        username = getIntent().getExtras().getString("username");

        apuntesTitle.setText("Apuntes de "+username);

        gtApuntes();
    }

    private void gtApuntes(){
        HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();

        new Thread(
                () ->{
                    String response = https.GETrequest(Constants.BASEURL +
                            "apuntes/"+username+".json");

                    Type type = new TypeToken<HashMap<String, Apunte>>(){}.getType();
                    Gson gson = new Gson();

                    HashMap<String, Apunte> apuntes = gson.fromJson(response, type);

                    if (apuntes!= null) {
                        apuntes.forEach(
                                (key, value) -> {
                                    runOnUiThread(
                                            () -> {apuntesTV.append(value.getBody() + "\n");}
                                    );
                                }
                        );
                    }else{
                        runOnUiThread(
                                () -> {
                                    Toast.makeText(this, "El usuario no tiene apuntes",
                                            Toast.LENGTH_LONG).show();}
                        );
                    }
                }
        ).start();
    }
}