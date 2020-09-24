package com.example.libretatelefonica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.UUID;

public class ContactsAdapter extends RecyclerView.Adapter<ContactView> implements ContactView.OnContactItemAction {

    private ArrayList<Contact> contacts;

    public ContactsAdapter(){
        contacts = new ArrayList<Contact>();

        contacts.add(new Contact(UUID.randomUUID().toString(), "Camila", "3173694663"));
        contacts.add(new Contact(UUID.randomUUID().toString(), "Conny", "3167521488"));
    }

    public void addContact(Contact contact){
        contacts.add(contact);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Here it generates de view of a item of the list view
        //XML -> View
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.contactrow, parent, false);
        ConstraintLayout rowroot = (ConstraintLayout) row;
        ContactView contactView = new ContactView(rowroot);
        contactView.setListener(this);

        return contactView;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactView holder, int position) {
        holder.setContact(contacts.get(position));
        holder.getTxtNombre().setText(contacts.get(position).getNombre());
        holder.getTxtTelefono().setText(contacts.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public void onDeleteContact(Contact contact) {
        contacts.remove(contact);
        notifyDataSetChanged();
    }
}
