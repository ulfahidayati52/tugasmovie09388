package com.example.d2a.aplikasilistmovie2;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MovieBoxOffice extends AppCompatActivity {
    ArrayList<String> ltitle;
    ArrayList<String> lrating;
    ArrayList<String> lstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_movie);
        SpinnerAdd();
    }
    public void SpinnerAdd() {

        Spinner spinner = (Spinner) findViewById(R.id.status);
        List<String> list = new ArrayList<String>();
        list.add("PLAYING");
        list.add("COMING SOON");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Add(View view) {
        Double temp;
        String rating,title , status;
        EditText edt;
        ltitle = getIntent().getStringArrayListExtra("title");
        lrating = getIntent().getStringArrayListExtra("rating");
        lstatus = getIntent().getStringArrayListExtra("status");
        try{
            edt = findViewById(R.id.title);
            title = edt.getText().toString();
            edt = findViewById(R.id.rating);
            rating = edt.getText().toString();
            Spinner spn = findViewById(R.id.status);
            status = String.valueOf(spn.getSelectedItem());
        }
        catch(Error e){
            title = "";
            rating = "0";
            status = "";
        }
        if(title != "" && status != "") {
            ltitle.add(title);
            lrating.add(rating);
            lstatus.add(status);
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("title",ltitle);
        intent.putExtra("rating",lrating);
        intent.putExtra("status",lstatus);
        view.getContext().startActivity(intent);
    }
}
