package pk.edu.pucit.recyclerviewdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    private int operator = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv;
        rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);


        Thread arithmetic = new Thread() {
            @Override
            public void run() {
                switch (operator) {
                    case 1:
                        add(1, 2);
                        break;
                    case 2:
                        subtract(1, 2);
                        break;
                }
            }

            void add(final int num1, final int num2) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Answer:  " + (num1 + num2), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            void subtract(int num1, int num2) {
            }

        };
        arithmetic.start();
//
//        String[] titles = new String[1000];
//        String[] subtitles = new String[1000];
//
//        for (int i = 0; i < titles.length; i++) {
//            titles[i] = "Title " + (i + 1);
//            subtitles[i] = "Subtitle " + (i + 1);
//        }
//        Integer[] imageids = {R.drawable.android_100x100, R.drawable.sample150};
//
//        RVAdapter adapter = new RVAdapter(this, titles, subtitles, imageids);
//
//        rv.setAdapter(adapter);
    }

    class MyAsyncTask extends AsyncTask<Integer, String, Object> {
        void add(int num1, int num2) {
            publishProgress("Answer: " + (num1 + num2));
        }

        void subtract(int num1, int num2) {
            publishProgress("Answer: " + (num1 - num2));
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Integer[] objects) {
            switch (operator) {
                case 1:
                    add(objects[0], objects[1]);
                    break;
                case 2:
                    subtract(objects[0], objects[1]);
                    break;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Toast.makeText(MainActivity.this, values[0], Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }
    }

}
