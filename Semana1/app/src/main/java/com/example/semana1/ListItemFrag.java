package com.example.semana1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ListItemFrag extends Fragment {

    //STATE

    public ListItemFrag() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ListItemFrag newInstance() {
        ListItemFrag fragment = new ListItemFrag();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_item, container, false);
    }
}