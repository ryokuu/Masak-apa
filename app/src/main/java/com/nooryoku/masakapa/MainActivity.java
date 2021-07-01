package com.nooryoku.masakapa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fb_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fb_add = findViewById(R.id.fb_add);

        fb_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogForm dialogForm = new DialogForm();
                dialogForm.show(getSupportFragmentManager(), "form");
            }
        });
    }
}