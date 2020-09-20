package com.example.semana1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ListItemFrag fragList;
    private NewItemFragment fragNewItem;
    private BottomNavigationView navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragList = ListItemFrag.newInstance();
        fragNewItem = NewItemFragment.newInstance();

        fragNewItem.setObserver(fragList);

        navigator = findViewById(R.id.navigator);

        showFragment(fragNewItem);

        navigator.setOnNavigationItemSelectedListener(
                (menuItem) -> {
                    switch(menuItem.getItemId()){
                        case (R.id.lista):
                            showFragment(fragNewItem);
                            break;
                        case (R.id.titulo):
                            showFragment(fragList);
                            break;
                    }
                    return true;
                }
        );
    }

    public void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }
}