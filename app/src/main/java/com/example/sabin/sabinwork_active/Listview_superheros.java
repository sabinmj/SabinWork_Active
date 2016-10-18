package com.example.sabin.sabinwork_active;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listview_superheros extends AppCompatActivity {


    private ArrayList<String> listOfSuperHeros = new ArrayList<String>();
    private ListView lvSuperHeros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_original);
        lvSuperHeros=(ListView)findViewById(R.id.lvsuperheros);
       initilizeData();
    }


    private void initilizeData() {
        listOfSuperHeros.add("Hulk");
        listOfSuperHeros.add("Bulk");
        listOfSuperHeros.add("Super Man");
        listOfSuperHeros.add("Spider Man");
        listOfSuperHeros.add("Batman");
        listOfSuperHeros.add("Iron Man");
        listOfSuperHeros.add("Thor");
        listOfSuperHeros.add("Ant Man");
        listOfSuperHeros.add("Deadpool");
        listOfSuperHeros.add("Rajinikanth");
        listOfSuperHeros.add("Shakthimaan");
        listOfSuperHeros.add("Bhudhimaan");
        listOfSuperHeros.add("Jai Hanuman");
        listOfSuperHeros.add("Vinay Noah");
        listOfSuperHeros.add("Felightians");
        listOfSuperHeros.add("Hulk");
        listOfSuperHeros.add("Bulk");
        listOfSuperHeros.add("Super Man");
        listOfSuperHeros.add("Spider Man");
        listOfSuperHeros.add("Batman");
        listOfSuperHeros.add("Iron Man");
        listOfSuperHeros.add("Thor");
        listOfSuperHeros.add("Ant Man");
        listOfSuperHeros.add("Deadpool");
        listOfSuperHeros.add("Rajinikanth");
        listOfSuperHeros.add("Shakthimaan");
        listOfSuperHeros.add("Bhudhimaan");
        listOfSuperHeros.add("Jai Hanuman");
        listOfSuperHeros.add("Vinay Noah");
        listOfSuperHeros.add("Felightians");


    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_list_item_1, listOfSuperHeros);
        lvSuperHeros.setAdapter(adapter);
//to retrieve the data for item select------>
        lvSuperHeros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tvData = (TextView) view;
                Toast.makeText(getBaseContext(),tvData.getText().toString() + " " + i,Toast.LENGTH_SHORT).show();
                          }
        });


}}
