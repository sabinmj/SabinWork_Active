package com.example.sabin.sabinwork_active.util;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sabin.sabinwork_active.shake_test;

/**
 * Created by sabin on 12-Aug-16.
 */
public class ShakeeventListner extends Service implements SensorEventListener {
    private static final float SHAKE_THRESHOLD = 800;
    private SensorManager sensorManager;
    private Sensor sensor;

    private TextView tvShake;
    private long lastUpdate;

    private float x;
    private float y;
    private float z;

    private float last_x;
    private float last_y;
    private float last_z;
    private shake_test.OnShakeListener mListener;
    private long mShakeTimestamp;
    private int mShakeCount;
    public int onStartCommand(Intent intent, int flags, int startId) {

        // Let it continue running until it is stopped.
        Toast.makeText(this, "U can shake nw", Toast.LENGTH_LONG).show();
//onSensorChanged();

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensor, SensorManager.SENSOR_DELAY_NORMAL);
        long curTime = System.currentTimeMillis();
        // only allow one update every 100ms.
        if ((curTime - lastUpdate) > 100) {
            long diffTime = (curTime - lastUpdate);
            lastUpdate = curTime;

            x = event.values[SensorManager.DATA_X];
            y = event.values[SensorManager.DATA_Y];
            z = event.values[SensorManager.DATA_Z];

            float speed = Math.abs(x+y+z - last_x - last_y - last_z) / diffTime * 10000;

            if (speed > SHAKE_THRESHOLD) {
                Log.d("sensor", "shake detected wd speed: " + speed);
                // tvShake.setText("Shake detected !! with speed : " + speed);
                Toast.makeText(getBaseContext(),"detected",Toast.LENGTH_SHORT).show();
            }
            last_x = x;
            last_y = y;
            last_z = z;


    }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
