package com.example.sabin.sabinwork_active;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sabin.sabinwork_active.util.sqlDbAdaptor;

public class update_store extends AppCompatActivity {
 private EditText name;
    private EditText dis;
    private EditText price;
    private EditText quan;
    private Button btn;
String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_store);
        name=(EditText)findViewById(R.id.etname);
        dis=(EditText)findViewById(R.id.etdis);
        price=(EditText)findViewById(R.id.etprice);
        quan=(EditText)findViewById(R.id.etquan);
        btn=(Button) findViewById(R.id.btnmodify);
        btn.setVisibility(View.INVISIBLE);
        Intent intent123=getIntent();
        name.setText(intent123.getStringExtra(store.NEWS_TYPE));
        dosql();
    }

    private void dosql() {
        sqlDbAdaptor dbAdapter = new sqlDbAdaptor(getBaseContext());
        dbAdapter.open();
        Cursor c = dbAdapter.getContact(name.getText().toString());
        if (c.moveToFirst())
            DisplayContact(c);

        else
            Toast.makeText(getBaseContext(), "No contact found",
                    Toast.LENGTH_LONG).show();
        dbAdapter.close();

    }
    private void DisplayContact(Cursor c) {
        // TODO Auto-generated method stub
        // Cursor resultSet =dbAdapter.getAllContacts();
        c.moveToFirst();
        this.id=c.getString(0);
        name.setText(c.getString(1));
       // this.name_sql=c.getString(1);
         dis.setText(c.getString(2));
        //this.dis_sql=c.getString(2);
        price.setText(c.getString(3));
      //  this.price_sql=c.getString(3);

        String abc=c.getString(4);
        String array []=abc.split(" ");
        String first=array[0];
        quan.setText(first);
      //  this.quan_sql=c.getString(4);
        btn.setVisibility(View.VISIBLE);
    }

   public void update_sql(View view) {


            sqlDbAdaptor dbAdapter = new sqlDbAdaptor(getBaseContext());

     dbAdapter.open();
        if (dbAdapter.updateContact
                (Integer.parseInt(id.toString()),
                       name.getText().toString(), dis.getText().toString(), price.getText().toString(), quan.getText().toString()))

            Toast.makeText(getBaseContext(), "Update successful.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getBaseContext(), "Update failed.",
                    Toast.LENGTH_LONG).show();
        dbAdapter.close();
}


    public void delete_sql(View view) {
        sqlDbAdaptor dbAdapter = new sqlDbAdaptor(getBaseContext());

        dbAdapter.open();
        dbAdapter.deleteContact(Integer.parseInt(id.toString()));
        dbAdapter.close();
        Toast.makeText(getBaseContext(), "Deleted......", Toast.LENGTH_LONG).show();
        Intent a= new Intent(getBaseContext(),store.class);
        startActivity(a);
    }
}

