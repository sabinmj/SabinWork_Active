package com.example.sabin.sabinwork_active;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Sensor_test extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensor;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_test);
        tvResult = (TextView) findViewById(R.id.tvresult);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

    }
    @Override
    protected void onStart() {
        super.onStart();
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent comingevent) {
        String data = " X : " + comingevent.values[0]
                +" Y : " + comingevent.values[1]
                +" Z : " + comingevent.values[2];
        tvResult.setText(data);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
