package com.example.libretatelefonica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView viewListContacts;
    private LinearLayoutManager layoutManager;
    private ContactsAdapter adapter;

    private EditText txtName;
    private EditText txtCellphone;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewListContacts = findViewById(R.id.viesListContacts);
        viewListContacts.setHasFixedSize(true);

        txtName = findViewById(R.id.txtName);
        txtCellphone = findViewById(R.id.txtCellphone);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this);

        layoutManager = new LinearLayoutManager(this);
        viewListContacts.setLayoutManager(layoutManager);

        adapter = new ContactsAdapter();
        viewListContacts.setAdapter(adapter);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnSave:
                Contact contact = new Contact(UUID.randomUUID().toString(), txtName.getText().toString(), txtCellphone.getText().toString());
                adapter.addContact(contact);
                break;
        }
    }
}