package com.refat.asynctasktest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn = (Button) findViewById(R.id.btnStart);
        tv = (TextView) findViewById(R.id.txtTime);
        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                AsyncTask<String,String,String> task = new AsyncTask<String, String, String>() {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                        //btn.setEnabled(false);
                    }

                    @Override
                    protected String doInBackground(String... params) {
                        int n = Integer.parseInt(params[0]);
                        for (int i=1;i<=n;i++) {
                            try {
                                Thread.sleep(1000);
                            } catch (Exception ex) {

                            }
                            publishProgress(String.valueOf(i));
                        }
                        return null;
                    }

                    @Override
                    protected void onProgressUpdate(String... values) {
                        super.onProgressUpdate(values);
                        tv.setText(values[0]);
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        //btn.setEnabled(true);
                    }
                };
                task.execute("5");
            }
        });
    }
}
