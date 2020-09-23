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

        this.root = root;

        txtNombre = root.findViewById(R.id.txtName);
        txtTelefono = root.findViewById(R.id.txtCellphone);
    }

    public ConstraintLayout getRoot() {
        return root;
    }

    public void setRoot(ConstraintLayout root) {
        this.root = root;
    }

    public TextView getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(TextView txtNombre) {
        this.txtNombre = txtNombre;
    }

    public TextView getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(TextView txtTelefono) {
        this.txtTelefono = txtTelefono;
    }
}
