package com.example.android.taufan_fadhilah_iskandar_1202150017_modul4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListName extends AppCompatActivity {

    ListView lvName;
    ProgressDialog mProgressBar;
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
        mProgressBar = new ProgressDialog(ListName.this);
        mProgressBar.setCancelable(true);
        mProgressBar.setTitle("Loading Data");
        mProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressBar.setMax(100);
        mProgressBar.setProgress(0);
        mProgressBar.show();
        new myTask().execute();
    }

    class myTask extends AsyncTask<Void, String, Void>{

        private ArrayAdapter<String> adapter;
        int count = 0;
        @Override
        protected void onPreExecute() {
            adapter=(ArrayAdapter<String>)lvName.getAdapter();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (String item: names){
                try {
                    publishProgress(item);
                    count += 20;
                    Thread.sleep(1000); // 2 segundos

                } catch(InterruptedException e) {

                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            int progress = count;
            mProgressBar.setProgress(progress);
            mProgressBar.setMessage(values[0]+" ("+progress+"%)");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mProgressBar.cancel();
            Toast.makeText(lvName.getContext(),"Async Complete",Toast.LENGTH_SHORT).show();
        }
    }
}
