package com.nooryoku.masakapa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogForm.DialogFormListener {
    ArrayList<DataMasakan> mDataMasakan = new ArrayList<>();
    //String judulMasakan, bahanUtama, Rempah;
    Context mContext;
    RecyclerAdapter mAdapter;
    FloatingActionButton fb_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("History Masakan");


        buildRecycleView();

        fb_add = findViewById(R.id.fb_add);

        fb_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogForm dialogForm = new DialogForm();
                dialogForm.show(getSupportFragmentManager(), "form");

            }
        });
    }

    @Override
    public void sendTexts(String dataMasakan, String dataBahan, String dataRempah,String dataTanggal) {
        insertItem(dataMasakan, dataBahan, dataRempah, dataTanggal);
    }

    private void insertItem(String masakan, String bahanUtama, String rempah, String tanggal) {
        mDataMasakan.add(new DataMasakan(masakan, bahanUtama, rempah, tanggal));
        mAdapter = new RecyclerAdapter(mDataMasakan, mContext);
        mAdapter.notifyItemInserted(mDataMasakan.size());
    }

    private void buildRecycleView() {
        RecyclerView rv_layout = findViewById(R.id.rv_layout);
        rv_layout.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        mAdapter = new RecyclerAdapter(mDataMasakan, getApplicationContext());

        rv_layout.setLayoutManager(mLayoutManager);
        rv_layout.setItemAnimator(new DefaultItemAnimator());
        rv_layout.setAdapter(mAdapter);
    }
}