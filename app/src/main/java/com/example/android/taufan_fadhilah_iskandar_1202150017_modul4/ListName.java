package com.example.android.taufan_fadhilah_iskandar_1202150017_modul4;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListName extends AppCompatActivity {

    ListView lvName;
    private String[] names = {
            "Taufan", "Fadhilah", "Iskandar", "Hanan", "Attaki"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_name);
        lvName = (ListView)findViewById(R.id.lvName);
        lvName.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));
    }

    public void startAsync(View view) {
        new myTask().execute();
    }

    class myTask extends AsyncTask<Void, String, Void>{

        private ArrayAdapter<String> adapter;
        @Override
        protected void onPreExecute() {
            adapter=(ArrayAdapter<String>)lvName.getAdapter();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (String item: names){
                publishProgress(item);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(lvName.getContext(),"Async Complete",Toast.LENGTH_SHORT).show();
        }
    }
}
