package com.example.sabin.sabinwork_active;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class shake_test extends AppCompatActivity implements SensorEventListener {
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
    private OnShakeListener mListener;
    private long mShakeTimestamp;
    private int mShakeCount;

    public static void setOnShakeListener(OnShakeListener listener) {
        //this.mListener = listener;
    }

    public interface OnShakeListener {
        public void onShake(int count);
    }
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake_test);

        tvShake = (TextView) findViewById(R.id.tvshake);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

    }
    @Override
    protected void onStart() {
        super.onStart();
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        long curTime = System.currentTimeMillis();
        // only allow one update every 100ms.
        if ((curTime - lastUpdate) > 100) {
            long diffTime = (curTime - lastUpdate);
            lastUpdate = curTime;

            x = sensorEvent.values[SensorManager.DATA_X];
            y = sensorEvent.values[SensorManager.DATA_Y];
            z = sensorEvent.values[SensorManager.DATA_Z];

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
