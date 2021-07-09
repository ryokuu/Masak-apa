package com.nooryoku.masakapa;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogForm extends DialogFragment {
    private RecyclerAdapter mAdapter;
    private DialogFormListener listener;
    EditText et_judulMasakan, et_bahanDasar, et_rempah;
    Button btn_save;

    public DialogForm(){
    }

    public DialogForm(RecyclerAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @SuppressLint("CutPasteId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.input_form,container,false);


        et_judulMasakan = view.findViewById(R.id.et_judulMasakan);
        et_bahanDasar = view.findViewById(R.id.et_bahanDasar);
        et_rempah = view.findViewById(R.id.et_rempah);

        btn_save = view.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputValidation()){
                    String judulMasakan = et_judulMasakan.getText().toString();
                    String bahanDasar = et_bahanDasar.getText().toString();
                    String rempah = et_rempah.getText().toString();
                    listener.sendTexts(judulMasakan, bahanDasar, rempah);
                    dismiss();
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (DialogFormListener) context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString()
                    + "must implement DialogFormListener");
        }
    }

    public interface DialogFormListener{
        void sendTexts(String dataMasakan, String dataBahan, String dataRempah );
    }

    private void input(EditText txt, String s){
        txt.setError("Data " +s+ " tidak boleh kosong");
        txt.requestFocus();
    }
    private boolean inputValidation(){
        if (et_judulMasakan.getText().toString().isEmpty()){
            input(et_judulMasakan, "masakan");
            return false;
        }else if (et_bahanDasar.getText().toString().isEmpty()) {
            input(et_bahanDasar, "bahan");
            return false;
        }else if (et_rempah.getText().toString().isEmpty()){
            input(et_rempah, "rempah");
            return false;
        }
        return true;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null){
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }

    }


}

                    /*
                    String masakanData = et_judulMasakan.getText().toString();
                    String bahanData = et_bahanDasar.getText().toString();
                    String rempahData = et_rempah.getText().toString();

                    Intent i = new Intent(v.getContext(), MainActivity.class);
                    i.putExtra("judul_masakan", masakanData);
                    i.putExtra("bahan_dasar", bahanData);
                    i.putExtra("rempah", rempahData);
                    startActivity(i);
                     */

    /*
    private void insertItem(String masakan, String bahanUtama, String rempah) {

        mDataMasakan.add(new DataMasakan(masakan, bahanUtama, rempah));
        mAdapter = new RecyclerAdapter(mDataMasakan);
        mAdapter.notifyItemInserted(mDataMasakan.size());
        dismiss();
    } */

                /*
                insertItem(et_judulMasakan.getText().toString(), et_bahanDasar.getText().toString(), et_rempah.getText().toString());
                Log.d("myDebug", "passed here" );
                Toast.makeText(view.getContext(), "Data tersimpan", Toast.LENGTH_SHORT).show(); */

//                rootNode = FirebaseDatabase.getInstance();
//                reference = rootNode.getReference("Masakan").push();
//
//                //get values
//                String masakan = et_judulMasakan.getText().toString();
//                String bahan_utama = et_judulMasakan.getText().toString();
//
//                DataMasakan dataMasakan = new DataMasakan(masakan, bahan_utama);
//
//                if(TextUtils.isEmpty(masakan)){
//                    input((EditText) et_judulMasakan, "Masakan");
//                }else if (TextUtils.isEmpty(bahan_utama)) {
//                    input((EditText) et_bahanDasar, "Bahan");
//                }else {
//                    Log.d("myDebug", "passed here" );
//                    reference.setValue(dataMasakan).addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            Toast.makeText(view.getContext(), "Data tersimpan", Toast.LENGTH_SHORT).show();
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(view.getContext(), "Data gagal tersimpan", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }