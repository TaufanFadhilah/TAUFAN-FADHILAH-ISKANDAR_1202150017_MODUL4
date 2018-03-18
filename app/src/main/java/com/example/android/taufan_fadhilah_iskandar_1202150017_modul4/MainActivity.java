package com.example.android.taufan_fadhilah_iskandar_1202150017_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void searchImage(View view) {
        Intent intent = new Intent(this, ImageSearch.class);
        startActivity(intent);
    }

    public void listName(View view) {
        Intent intent = new Intent(this, ListName.class);
        startActivity(intent);
    }
}
