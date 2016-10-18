package com.example.sabin.sabinwork_active.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by sabin on 17-Aug-16.
 */
public class airplane_on_off extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Aeroplane mode detected",Toast.LENGTH_SHORT).show();
    }
}
