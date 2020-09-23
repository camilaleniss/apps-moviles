package com.example.libretatelefonica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactView> {

    private ArrayList<Contact> contacts;

    public ContactsAdapter(){
        contacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    @NonNull
    @Override
    public ContactView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //XML -> View
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.contactrow, null);
        ConstraintLayout rowroot = (ConstraintLayout) row;
        ContactView contactView = new ContactView(rowroot);

        return contactView;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
