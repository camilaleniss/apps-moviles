package com.example.libretatelefonica;

import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ContactView extends RecyclerView.ViewHolder {

    private ConstraintLayout root;
    private TextView txtNombre;
    private TextView txtTelefono;

    public ContactView(ConstraintLayout root){
        super(root);
    }


}
