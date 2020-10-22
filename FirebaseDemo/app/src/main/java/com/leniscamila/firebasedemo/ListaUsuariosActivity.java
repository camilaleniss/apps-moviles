package com.leniscamila.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.leniscamila.firebasedemo.model.User;
import com.leniscamila.firebasedemo.util.Constants;
import com.leniscamila.firebasedemo.util.HTTPSWebUtilDomi;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class ListaUsuariosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView userList;
    private ArrayAdapter<String> usuariosAdapter;
    private ArrayList<String> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        userList = findViewById(R.id.userList);

        usuarios = new ArrayList<>();
        usuariosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usuarios);
        userList.setAdapter(usuariosAdapter);

        getUsuarios();

        userList.setOnItemClickListener(this);
    }

    public void getUsuarios(){
        HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();
        Gson gson = new Gson();

        new Thread(
                () -> {
                    String response = https.GETrequest(Constants.BASEURL+"users.json");
                    Type type = new TypeToken<HashMap<String, User>>(){}.getType();

                    HashMap<String, User> users = gson.fromJson(response, type);

                    users.forEach(
                            (key, value) -> {
                                usuarios.add(value.getNombre());
                            }
                    );

                    runOnUiThread(
                            () -> { usuariosAdapter.notifyDataSetChanged();}
                    );
                }
        ).start();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, ListaApuntesActivity.class);
        intent.putExtra("username", usuarios.get(i));
        startActivity(intent);
    }
}