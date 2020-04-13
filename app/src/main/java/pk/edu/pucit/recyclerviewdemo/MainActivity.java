package pk.edu.pucit.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv;
        rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);


        String[] titles = new String[1000];
        String[] subtitles = new String[1000];

        for (int i = 0; i < titles.length; i++) {
            titles[i] = "Title " + (i + 1);
            subtitles[i] = "Subtitle " + (i + 1);
        }
        Integer[] imageids = {R.drawable.android_100x100, R.drawable.sample150};

        RVAdapter adapter = new RVAdapter(this,titles,subtitles,imageids);

        rv.setAdapter(adapter);


    }
}
