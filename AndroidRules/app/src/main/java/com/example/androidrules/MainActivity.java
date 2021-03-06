package com.example.androidrules;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements Counter.onCounterChange, View.OnClickListener {

    private TextView txtCounter;
    private Counter counter;

    private EditText txtURL;
    private Button btnEnter;
    private TextView txtViewResponse;

    private HTTPUtil util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCounter = findViewById(R.id.txtCounter);
        counter = new Counter();
        counter.setObserver(this);
        counter.start();

        txtURL = findViewById(R.id.txtURL);
        btnEnter = findViewById(R.id.btnEnter);
        txtViewResponse = findViewById(R.id.txtViewResponse);

        btnEnter.setOnClickListener(this);

        txtViewResponse.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void onCounterValue(int value) {
        //Está corriendo en el worker, no es el hilo UI
        runOnUiThread(
                () -> {
                    txtCounter.setText(""+value);
                }
        );
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnEnter:
                String url = txtURL.getText().toString();
                util = new HTTPUtil(url);

                util.setObserver(
                        response -> {
                            runOnUiThread(
                                    ()->{
                                        txtViewResponse.setText(response);
                                    }
                            );
                        }
                );
                util.start();

                break;
        }
    }


}