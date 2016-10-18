package com.example.sabin.sabinwork_active;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sabin.sabinwork_active.task.Bubblesort;
import com.example.sabin.sabinwork_active.task.Insertionsort;
import com.example.sabin.sabinwork_active.task.Mergesort;
import com.example.sabin.sabinwork_active.task.Quicksort;
import com.example.sabin.sabinwork_active.task.Selectionsort;
import com.example.sabin.sabinwork_active.util.sorting;

public class BenchmarkAlgorithem extends AppCompatActivity {


    private EditText etarrsysize;
    private RadioGroup rgcomplexicity;
    private TextView tvTextView;
    private static int[] array;
    int size;
    private  TextView tvbubble;
    private TextView tvselection;
    private  TextView merge;
    private  TextView quick;
    private  TextView insertion;
    private  TextView heap;


    public void genreate_array(View view) {
        try{
            size=Integer.parseInt(etarrsysize.getText().toString());
            switch(rgcomplexicity.getCheckedRadioButtonId()) {

                case R.id.rbbest :
                    array=sorting.createBestCase(size);
                    tvTextView.setText("Best Case selected \n and Array of size "+size+" Generated");


                    break;
                case R.id.rbaverage :
                    array=sorting.generateRandom(size);
                    tvTextView.setText("Average Case selected \n and Array of size "+size+" Generated");


                    break;
                case R.id.rbworst :
                    array=sorting.createWorstCase(size);
                    tvTextView.setText("Worst Case selected \n and Array of size "+size+" Generated");


                    break;
            }}  catch(Exception e)
        {
            Toast.makeText(getBaseContext(),"Enter Array Size",Toast.LENGTH_SHORT).show();
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benchmarkalgorithem);
        rgcomplexicity = (RadioGroup) findViewById(R.id.rgcomplexicity);
        etarrsysize=(EditText)findViewById((R.id.etarraysize));
        tvTextView=(TextView)findViewById(R.id.tvgeneratearray);
        tvbubble=(TextView)findViewById(R.id.tvbubble);
        tvselection=(TextView)findViewById(R.id.tvselection);
        merge=(TextView)findViewById(R.id.tvmerge);
        insertion=(TextView)findViewById(R.id.tvinsertion);
        //  heap=(TextView)findViewById(R.id.tvh);
        quick=(TextView)findViewById(R.id.tvquick);


    }


    public Integer[] convert(){


        Integer[] s1=new Integer[size];

        for(int i=0;i<array.length;i++){

            s1[i]=array[i];
        }
        Log.i("sabin", String.valueOf(array.length));

        return s1;
    }


    public void dosorting(View view) {
        try{
            switch (view.getId()){
                case R.id.btnbubble:
                    bubblesort();
                    break;
                case R.id.btnselection:
                    selectionsort();

                    break;
                case R.id.btnmerge:
                    MergeSort();

                    break;
                case R.id.btnquick:
                    QuickSort();
                    break;
                case R.id.btninsertion:
                    insertion();
                    break;

                case R.id.btnbenchmarkall:
                    bubblesort();
                    selectionsort();
                    MergeSort();
                    QuickSort();
                    insertion();


            }} catch(Exception e)
        {
            //Toast.makeText(getBaseContext(),"Select an array",Toast.LENGTH_SHORT).show();
        }


    }

    public Integer[] clonearray() {

        Integer[] clonearray = new Integer[size];
        for (int i = 0; i < size; i++) {
            clonearray[i] = array[i];
        }
        return clonearray;
    }

    public void bubblesort() {
        new Bubblesort(this).execute(convert());
    }

    public void selectionsort() {
        new Selectionsort(this).execute(clonearray());
    }

    public void insertion() {

        new Insertionsort(this).execute(convert());

    }

    public void MergeSort() {
        new Mergesort(this).execute(convert());

    }

    public void QuickSort() {
        new Quicksort(this).execute(convert());

    }




}
