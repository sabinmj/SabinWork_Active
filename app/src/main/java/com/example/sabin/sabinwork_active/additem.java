package com.example.sabin.sabinwork_active;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sabin.sabinwork_active.util.sqlDbAdaptor;

import java.util.ArrayList;
import java.util.List;

public class additem extends AppCompatActivity implements OnItemSelectedListener{
 private Spinner spin;
    private EditText productname;
    private EditText productdiscription;
    private EditText productprice;
    private EditText productquantity;
    private TextView tvresult;
    private TextView tvshow;
    String item_select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);
       // spin=(Spinner)findViewById(R.id.spinner);
        productname=(EditText) findViewById(R.id.etname);
        productdiscription=(EditText) findViewById(R.id.etdiscription);
        productprice=(EditText) findViewById(R.id.etprice);
        productquantity=(EditText) findViewById(R.id.etquantity);
        //tvresult=(TextView) findViewById(R.id.tvresult);
       // tvshow=(TextView) findViewById(R.id.tvshow);


        // Spinner click listener
       // spin.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("gram");
        categories.add("Kg");
        categories.add("Litter");
        categories.add("Ton");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
//        spin.setAdapter(dataAdapter);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
// On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
       // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        this.item_select=item;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void additem_sql(View view) {
String n=productname.getText().toString();
        String disc=productdiscription.getText().toString();
        String price=productprice.getText().toString();
        String quanti=productquantity.getText().toString();

        //persisting the data
        sqlDbAdaptor dbAdapter = new sqlDbAdaptor(getBaseContext());
        dbAdapter.open();

        dbAdapter.insertContact(n,disc,price,quanti);
        Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show();
        Log.d("save", "");
        dbAdapter.close();








    }




}