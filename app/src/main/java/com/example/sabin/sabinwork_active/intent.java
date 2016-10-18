package com.example.sabin.sabinwork_active;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class intent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }

    public void dointent(View view) {
        switch (view.getId()) {
            case R.id.btngreetuser:
                Intent intentfuncrionA = new Intent(getBaseContext(), greet_user.class);
                startActivity(intentfuncrionA);
                break;
          case R.id.btncalculator:
                Intent intentfuncrionb = new Intent(getBaseContext(), calculator.class);
                startActivity(intentfuncrionb);
                break;
        /*    case R.id.btnbenchmark:
                Intent intentfuncrionc = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intentfuncrionc);
                break;*/
            case R.id.btnureg:
                Intent intentfuncriond = new Intent(getBaseContext(), userregistration.class);
                startActivity(intentfuncriond);
                break;

            case R.id.btnanimation:
                Intent intentfuncrione = new Intent(getBaseContext(), Animationtest.class);
                startActivity(intentfuncrione);
                break;

            case R.id.btninstagram:
                Intent intentfuncrionf = new Intent(getBaseContext(), Instagramclone.class);
                startActivity(intentfuncrionf);
                break;
            case R.id.btnshake:
                Intent intentfuncriong = new Intent(getBaseContext(), shake_test.class);
                startActivity(intentfuncriong);
                break;
            case R.id.btnmp3player:
                Intent intentfuncrionj = new Intent(getBaseContext(), Mp3player.class);
                startActivity(intentfuncrionj);
                break;
            case R.id.btnstore:
                Intent intentfuncrionh = new Intent(getBaseContext(), store.class);
                startActivity(intentfuncrionh);
                break;
            case R.id.btnsensor:
                Intent intentfuncrioni = new Intent(getBaseContext(), Sensor_test.class);
                startActivity(intentfuncrioni);
                break;
            case R.id.movie:
                Intent intentfuncrionjx = new Intent(getBaseContext(), MovieList_Json.class);
                startActivity(intentfuncrionjx);
                break;
            case R.id.speech:
                Intent intentfuncrionjx1 = new Intent(getBaseContext(), textToSpeech.class);
                startActivity(intentfuncrionjx1);
                break;
            case R.id.saxparsing:
                Intent intentfuncrionjx11 = new Intent(getBaseContext(), SAXparsing.class);
                startActivity(intentfuncrionjx11);
                break;
            case R.id.btnsensorlist:
                Intent intentfuncrionjx101 = new Intent(getBaseContext(), listOfSensors.class);
                startActivity(intentfuncrionjx101);
                break;
            case R.id.btnwebview:
                Intent intentfuncrionjx101m = new Intent(getBaseContext(), Webview_demo.class);
                startActivity(intentfuncrionjx101m);
                break;
            case R.id.btnbenchmark_algorithem:
                Intent intentfuncrionjx101m3 = new Intent(getBaseContext(), BenchmarkAlgorithem.class);
                startActivity(intentfuncrionjx101m3);
                break;
            case R.id.btnsuperhero:
                Intent intentfuncrionjx101m2 = new Intent(getBaseContext(), Listview_superheros.class);
                startActivity(intentfuncrionjx101m2);
                break;
            case R.id.btnSpeechtotext:
                Intent intentfuncrionjx101m24 = new Intent(getBaseContext(), SpeechToText.class);
                startActivity(intentfuncrionjx101m24);
                break;

        }
    }
}