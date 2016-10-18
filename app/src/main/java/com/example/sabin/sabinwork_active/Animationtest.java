package com.example.sabin.sabinwork_active;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Animationtest extends AppCompatActivity {
 private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        image =(ImageView)findViewById(R.id.imgbtn);
    }

    public void animation(View view) {
       switch (view.getId()){
           case R.id.btnrotation:
               ObjectAnimator rotateA=ObjectAnimator.ofFloat(image,"rotation",0,360,0,360,0,360,90,0);
        rotateA.setDuration(3000);
        rotateA.start();
               break;

           case R.id.btnfin:
               ObjectAnimator rotateb=ObjectAnimator.ofFloat(image,"alpha",0,1,0,0,1);
               rotateb.setDuration(3000);
               rotateb.start();
               break;
           case R.id.btnfout:
               ObjectAnimator rotatec=ObjectAnimator.ofFloat(image,"alpha",1,0,1,0,1,0);
               rotatec.setDuration(3000);
               rotatec.start();
               break;
           case R.id.btnx:
               ObjectAnimator rotated=ObjectAnimator.ofFloat(image, "translationX", 0,200);
               rotated.setDuration(3000);
               rotated.start();
               break;
           case R.id.btny:
               ObjectAnimator rotatee=ObjectAnimator.ofFloat(image, "translationY", 0,200);
               rotatee.setDuration(3000);
               rotatee.start();
               break;
           case R.id.btnshake:
               Animation shake = AnimationUtils.loadAnimation(Animationtest.this, R.anim.shake);

               image.startAnimation(shake);

               break;


       }}

    public void all(View view) {
        ObjectAnimator rotatee=ObjectAnimator.ofFloat(image, "translationY", 0,200);
        rotatee.setDuration(3000);
        rotatee.start();
        ObjectAnimator rotated=ObjectAnimator.ofFloat(image, "translationX", 0,200);
        rotated.setDuration(3000);
        rotated.start();
        ObjectAnimator rotatec=ObjectAnimator.ofFloat(image,"alpha",1,0,1,0,1,0,1);
        rotatec.setDuration(3000);
        rotatec.start();
        ObjectAnimator rotateA=ObjectAnimator.ofFloat(image,"rotation",0,360,0,360,0,360,90,0);
        rotateA.setDuration(3000);
        rotateA.start();
        Animation shake = AnimationUtils.loadAnimation(Animationtest.this, R.anim.shake);

        image.startAnimation(shake);
    }
}
