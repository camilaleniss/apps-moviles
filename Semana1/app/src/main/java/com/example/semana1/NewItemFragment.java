package com.example.semana1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class NewItemFragment extends Fragment implements View.OnClickListener{

    //State

    //Views
    private  EditText inputTask;
    private Button butSubmit;

    //referencia del otro fragmento observador
    private OnTaskAddedListener observer;

    public NewItemFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NewItemFragment newInstance() {
        NewItemFragment fragment = new NewItemFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //It makes fragment visible
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_new_item, container, false);

        inputTask = root.findViewById(R.id.inputTask);
        butSubmit = root.findViewById(R.id.butSubmit);

        butSubmit.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.butSubmit:
                String task = inputTask.getText().toString();
                observer.onTaskAdded(task);
                break;
        }
    }

    public void setObserver(OnTaskAddedListener observer){
        this.observer =observer;
    }

    //Implementation of observer pattern
    public interface OnTaskAddedListener{
        void onTaskAdded(String task);
    }
}