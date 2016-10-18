package com.example.sabin.sabinwork_active;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by sabin on 7/1/2016.
 */
public class calculator extends Activity {
    private EditText et1;
    private EditText et2;
    private TextView tv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        et1 = (EditText) findViewById(R.id.etfirstnum);
        et2 = (EditText) findViewById(R.id.etsecondnum);

    }


    public void docalculation(View view) throws Exception {
        tv = (TextView) findViewById(R.id.tvresult);

        try {


            double s1 = Double.parseDouble(et1.getText().toString());
            double s2 = Double.parseDouble(et2.getText().toString());
            switch (view.getId()) {
                case R.id.btnadd:
                    tv.setText(" " + (s1 + s2));
                    Log.d("sabin",""+(s1+s2));
                    break;
                case R.id.btnsub:
                    tv.setText(" " + (s1 - s2));
                    Log.d("sabin",""+(s1 - s2));
                    break;
                case R.id.btnmul:
                    tv.setText(" " + (s1 * s2));
                    Log.d("sabin",""+(s1 *s2));
                    break;
                case R.id.btndiv:
                    tv.setText(" " + (s1 / s2));
                    Log.d("sabin",""+(s1 /s2));
                    break;
                case R.id.btnmode:
                    tv.setText(" " + (s1 % s2));
                    Log.d("sabin",""+(s1 % s2));
                    break;


            }
        }
        catch (Exception e) {
          //  throw new  Exception(e);
tv.setText("Enter number !!!");

        }

    }}