package com.example.listdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listProgramming;
    private ArrayList<String> programmingLanguages;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProgramming = findViewById(R.id.listProgramming);

        programmingLanguages = new ArrayList<String>();
        programmingLanguages.add("Java");
        programmingLanguages.add("Golang");
        programmingLanguages.add("Python");
        programmingLanguages.add("JavaScript");
        programmingLanguages.add("C++");
        programmingLanguages.add("C#");
        programmingLanguages.add("Swift");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) listProgramming);
        listProgramming.setAdapter(adapter);

        listProgramming.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id ){
                        Toast.makeText(MainActivity.this, programmingLanguages.get(position), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}