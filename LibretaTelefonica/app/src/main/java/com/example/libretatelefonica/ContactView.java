package com.example.libretatelefonica;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

//View Model -> Model of the view to represent a item
public class ContactView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ConstraintLayout root;
    private TextView txtNombre;
    private TextView txtTelefono;

    private Button btnDelete;
    private Button btnCall;

    private Contact contact;

    private OnContactItemAction listener;

    public ContactView(ConstraintLayout root){
        super(root);

        this.root = root;

        txtNombre = root.findViewById(R.id.txtName);
        txtTelefono = root.findViewById(R.id.txtCellphone);

        btnDelete = root.findViewById(R.id.btnDelete);
        btnCall = root.findViewById(R.id.btnCall);

        btnDelete.setOnClickListener(this);
        btnCall.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnDelete:
                if (listener != null) listener.onDeleteContact(this.contact);
                break;
            case R.id.btnCall:
                Toast.makeText(root.getContext(), contact.getTelefono(), Toast.LENGTH_SHORT).show();
                //To call you need an intent
                break;
        }
    }

    public void setListener(OnContactItemAction listener){
        this.listener = listener;
    }

    public void setContact(Contact contact){
        this.contact = contact;
    }

    public interface OnContactItemAction{
        void onDeleteContact(Contact contact);
    }
}
