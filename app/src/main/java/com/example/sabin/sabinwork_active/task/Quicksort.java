package com.example.sabin.sabinwork_active.task;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.sabin.sabinwork_active.R;
import com.example.sabin.sabinwork_active.util.QuickSort;

/**
 * Created by sabin on 7/8/16.
 */
public class Quicksort extends AsyncTask<Integer[],Integer,int[]> {

    private Activity activity;
    private long start;
    private long stop;
    private TextView tvQuickssort;

    public Quicksort(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected int[] doInBackground(Integer[]... inputArr) {

        Log.i("sabin","quick");

        Integer[]array = inputArr[0];
        Log.i("size", String.valueOf(array.length));
        start = System.currentTimeMillis();

        QuickSort.sorting(array);
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvQuickssort=(TextView)activity.findViewById(R.id.tvquick);

    }

    @Override
    protected void onPostExecute(int[] ints) {
        super.onPostExecute(ints);
        stop = System.currentTimeMillis();
        tvQuickssort.setText(stop - start + "ms");
    }


}
