package com.example.d2a.aplikasilistmovie2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<BuildMovie> s1= new ArrayList<BuildMovie>();
    private RecyclerView r1;
    private MovieAdapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getIntent().hasExtra("title") && getIntent().hasExtra("rating") && getIntent().hasExtra("status")){

            ArrayList<String> title = getIntent().getStringArrayListExtra("title");
            ArrayList<String> rating = getIntent().getStringArrayListExtra("rating");
            ArrayList<String> status = getIntent().getStringArrayListExtra("status");
            System.out.println("Error 2");
            for (int i = 0; i < title.size(); i++) {
                s1.add(new BuildMovie(title.get(i), rating.get(i), status.get(i)));
            }

        }
        else{
            s1.add(new BuildMovie("title", "rating", "status"));

        }
        ad = new MovieAdapter(this, s1);
        r1 = findViewById(R.id.Recycler);
        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MovieBoxOffice.class);
                ArrayList<String> mtitle = new ArrayList<String>();
                ArrayList<String> mrating = new ArrayList<String>();
                ArrayList<String> mstatus = new ArrayList<String>();
                for(int i = 0; i < s1.size(); i++){
                    mtitle.add(s1.get(i).title);
                    mrating.add(String.valueOf(s1.get(i).rating));
                    mstatus.add(s1.get(i).status);
                }
                intent.putStringArrayListExtra("title", mtitle);
                intent.putStringArrayListExtra("rating", mrating);
                intent.putStringArrayListExtra("status", mstatus);
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
