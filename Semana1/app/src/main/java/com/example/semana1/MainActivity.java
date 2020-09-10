package com.example.semana1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int CODE = 1;

    private TextView labelWelcome;
    private ImageView logoIcesi;
    private EditText inputUsername;
    private EditText inputPassword;
    private Button butLogIn;

    //Primer método que se ejecuta en una actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar métodos
        labelWelcome = findViewById(R.id.labelWelcome);
        logoIcesi = findViewById(R.id.logoIcesi);
        inputUsername = findViewById(R.id.inputUsername);
        inputPassword = findViewById(R.id.inputPassword);
        butLogIn = findViewById(R.id.butLogIn);

        butLogIn.setOnClickListener(
                (view) -> {
                    //Esto es una función lambda, aquí va mi acción
                    String username = inputUsername.getText().toString();
                    String password = inputPassword.getText().toString();
                    //Toast.makeText(this, username+"  "+password, Toast.LENGTH_LONG).show();

                    //Intent allows you to travel from an activity to other

                    Intent intent = new Intent(this, ProfileActivity.class);
                    intent.putExtra("username", username);
                    startActivityForResult(intent, CODE);
                }
        );
    }

    //Ctrl + O para override

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CODE && resultCode == RESULT_OK){
            String username = data.getExtras().getString("username");
            inputUsername.setText(username);
        }
    }
}