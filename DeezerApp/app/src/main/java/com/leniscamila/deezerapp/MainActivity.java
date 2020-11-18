package com.leniscamila.deezerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.leniscamila.deezerapp.comunication.HTTPSWebUtilDomi;
import com.leniscamila.deezerapp.model.TopDeezer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(
                () -> {
                    HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();

                    String json = https.GETrequest("https://api.deezer.com/artist/27/top");

                    Gson gson = new Gson();

                    TopDeezer deezer = gson.fromJson(json, TopDeezer.class);

                    Log.e(">>>>", deezer.getData()[0].getTitle());
                }


        ).start();


    }
}