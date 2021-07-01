package com.nooryoku.masakapa;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Tag;

public class DialogForm extends DialogFragment {
    String masakan, bahan_utama;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    public DialogForm() {
    }

    public DialogForm(String masakan, String bahan_utama ) {
        this.masakan = masakan;
        this.bahan_utama = bahan_utama;
    }

    EditText et_judulMasakan;
    EditText et_bahanDasar;

    Button btn_save;

    @SuppressLint("CutPasteId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.input_form,container,false);


        et_judulMasakan = view.findViewById(R.id.et_judulMasakan);
        et_bahanDasar = view.findViewById(R.id.et_judulMasakan);
        btn_save = (Button) view.findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Masakan").push();

                //get values
                String masakan = et_judulMasakan.getText().toString();
                String bahan_utama = et_judulMasakan.getText().toString();

                DataMasakan dataMasakan = new DataMasakan(masakan, bahan_utama);

                if(TextUtils.isEmpty(masakan)){
                    input((EditText) et_judulMasakan, "Masakan");
                }else if (TextUtils.isEmpty(bahan_utama)) {
                    input((EditText) et_bahanDasar, "Bahan");
                }else {
                    Log.d("myDebug", "passed here" );
                    reference.setValue(dataMasakan).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(view.getContext(), "Data tersimpan", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(view.getContext(), "Data gagal tersimpan", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        return view;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null){
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }

    }

    private void input(EditText txt, String s){
    txt.setError(s+ "Data tidak boleh kosong");
    txt.requestFocus();
    }
}