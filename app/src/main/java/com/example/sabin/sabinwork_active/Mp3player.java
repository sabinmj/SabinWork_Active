package com.example.sabin.sabinwork_active;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Mp3player extends Activity implements SensorEventListener {
    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;

    private static final float SHAKE_THRESHOLD = 800;
    private SensorManager sensorManager;
    private Sensor sensor;
    String next_song = null;

    private long lastUpdate;

    private float x;
    private float y;
    private float z;

    private float last_x;
    private float last_y;
    private float last_z;
    private View view;

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

            float speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;

            if (speed > SHAKE_THRESHOLD) {
                //Log.d("sensor", "shake detected w/ speed: " + speed);
                mediaPlayer1.stop();
                mediaPlayer2.start();
                this.next_song = "1";

            }
            last_x = x;
            last_y = y;
            last_z = z;
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3player);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.song);

        mediaPlayer2 = MediaPlayer.create(this, R.raw.song1);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

    }

    public void playsong(View view) {
        this.view = view;
        if (next_song == null) {
            switch (view.getId()) {
                case R.id.btnplay:
                    mediaPlayer1.start();
                    Toast.makeText(this, "play 1", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btnpause:
                    mediaPlayer1.pause();
                    Toast.makeText(this, "pause 1", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
   /* else{

    switch (view.getId()){
        case R.id.btnplay:
            mediaPlayer1.stop();
            mediaPlayer2.start();
            Toast.makeText(this,"play 2",Toast.LENGTH_SHORT).show();
            break;

        case R.id.btnpause:
            mediaPlayer1.stop();
            mediaPlayer2.pause();
            Toast.makeText(this,"pause 2",Toast.LENGTH_SHORT).show();
            break;
    }*/




    }
    @Override
    protected void onStart() {
        super.onStart();
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

}
