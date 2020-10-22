package com.leniscamila.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.leniscamila.firebasedemo.model.User;
import com.leniscamila.firebasedemo.util.Constants;
import com.leniscamila.firebasedemo.util.HTTPSWebUtilDomi;

import java.util.Date;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameET;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameET = findViewById(R.id.usernameET);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.loginBtn:
                //Post of the user
                User user = new User(UUID.randomUUID().toString(), usernameET.getText().toString(),
                        new Date().getTime());

                Gson gson = new Gson();
                String json = gson.toJson(user);

                HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();
                new Thread(
                        ()->{
                            String response = https.PUTrequest(Constants.BASEURL+"users/"+user.getNombre()+
                                    ".json", json);
                            runOnUiThread(
                                    () -> {
                                        Intent i = new Intent(this, ApuntesActivity.class);
                                        i.putExtra("username", user.getNombre());
                                        startActivity(i);
                                    }
                            );
                        }
                ).start();
                break;
        }
    }
}