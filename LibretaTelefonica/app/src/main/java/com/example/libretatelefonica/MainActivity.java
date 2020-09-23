package com.example.libretatelefonica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView viewListContacts;
    private LinearLayoutManager layoutManager;
    private ContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewListContacts = findViewById(R.id.viesListContacts);
        viewListContacts.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        viewListContacts.setLayoutManager(layoutManager);

        adapter = new ContactsAdapter();
        viewListContacts.setAdapter(adapter);


    }
}