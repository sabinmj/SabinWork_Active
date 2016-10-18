package com.example.sabin.sabinwork_active;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sabin.sabinwork_active.util.sqlDbAdaptor;

public class store extends AppCompatActivity {


    public static final String NEWS_TYPE = null;
    String name;
    String id=null;
    String dis;
    String price;
    String quant;
private Button modify;
 SharedPreferences sharedpreferences;

    private EditText search;
    private TextView result;
    final sqlDbAdaptor db = new sqlDbAdaptor(store.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        search=(EditText) findViewById(R.id.etsearch);
       // result=(TextView) findViewById(R.id.tvresult);
 modify=(Button)findViewById(R.id.btnmodify);
        modify.setVisibility(View.GONE);
    }

    public void additem(View view) {
        Intent intent=new Intent(getBaseContext(),additem.class);
        startActivity(intent);
    }


    public void searchbyname(View view) {
        db.open();
        Cursor c = db.getContact(search.getText().toString());
        if (c.moveToFirst())
            DisplayContact(c);
        else
            Toast.makeText(getBaseContext(), "No contact found",
                    Toast.LENGTH_LONG).show();
        db.close();
    }

    private void DisplayContact(Cursor c) {
        // TODO Auto-generated method stub
       // Cursor resultSet =dbAdapter.getAllContacts();
        c.moveToFirst();
         this.id=c.getString(0);
        this.name = c.getString(1);
        this.dis = c.getString(2);
       this.price = c.getString(3);
        this.quant = c.getString(4);
        String[] mobileArray = {"Product name    "+name,"Product Discription     "+dis,"Price    "+price,"Quantity    "+quant};

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.listview_trial ,mobileArray);
        ListView listView = (ListView) findViewById(R.id.lvshow);
        listView.setAdapter(adapter);
      //  result.setText(name+"\n" +dis+"\n" +price+"\n" +quant);


        listView.setVisibility(View.VISIBLE);
        modify.setVisibility(View.VISIBLE);

    }

    public  void modify_sql(View view)
    {

      Intent intentabc=new Intent(getBaseContext(),update_store.class);
     //   update_store up=new update_store();
      //up.modify_value_send(id,name,dis,price,quant);
        intentabc.putExtra(NEWS_TYPE,name);
       startActivity(intentabc);


    }

}




