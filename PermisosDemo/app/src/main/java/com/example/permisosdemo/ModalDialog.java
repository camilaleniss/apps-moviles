package com.example.permisosdemo;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ModalDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ModalDialog extends DialogFragment implements  View.OnClickListener{

    private EditText txtURL;
    private Button btnSubmit;

    private OnOkListener listener;

    public ModalDialog() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ModalDialog newInstance() {
        ModalDialog fragment = new ModalDialog();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_modal_dialog, container, false);

        txtURL = root.findViewById(R.id.txtURL);
        btnSubmit = root.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(this);

        return root;
    }

    public void setListener(OnOkListener Listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnSubmit:
                if (listener == null){
                    Log.e("Error", "There is not listener");
                }else{
                    listener.onOk(txtURL.getText().toString());
                }
                this.dismiss();
            break;
        }
    }

    public interface OnOkListener{
        void onOk(String url);
    }
}