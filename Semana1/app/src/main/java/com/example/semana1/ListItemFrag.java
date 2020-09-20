package com.example.semana1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListItemFrag extends Fragment implements NewItemFragment.OnTaskAddedListener {

    //STATE
    private ArrayList<String> tasks;

    private TextView txtTasks;

    public ListItemFrag() {
        // Required empty public constructor
        this.tasks = new ArrayList<String>();
    }

    // TODO: Rename and change types and number of parameters
    public static ListItemFrag newInstance() {
        ListItemFrag fragment = new ListItemFrag();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_list_item, container, false);
        txtTasks = root.findViewById(R.id.textTasks);

        txtTasks.setText("");
        for (int i = 0; i<this.tasks.size(); i++){
            String tasks = this.tasks.get(i);
            txtTasks.append(tasks+"\n");
        }

        return root;
    }

    @Override
    public void onTaskAdded(String task){
        this.tasks.add(task);
        //Forbidden use  View or UI Thread
    }
}