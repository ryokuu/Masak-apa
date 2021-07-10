package com.nooryoku.masakapa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ItemDetailActivity extends AppCompatActivity {
    TextView judul, tanggal, bahan, rempah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        judul = findViewById(R.id.tv_judulMasakan);
        tanggal = findViewById(R.id.tv_tanggal);
        bahan = findViewById(R.id.tv_bahanUtama);
        rempah = findViewById(R.id.tv_rempah);

        judul.setText(getIntent().getStringExtra("judul"));
        tanggal.setText(getIntent().getStringExtra("tanggal"));
        bahan.setText(getIntent().getStringExtra("bahan"));
        rempah.setText(getIntent().getStringExtra("rempah"));
    }
}