package com.example.sabin.sabinwork_active;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

public class greet_user extends AppCompatActivity {
 private EditText et1;
    private EditText et2;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String secname = "secname";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet_user);
        et1=(EditText)findViewById(R.id.etfirstname) ; //initialisation
        et2=(EditText)findViewById(R.id.etsecondname) ;
        sharedpreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        et1.setText(sharedpreferences.getString(Name,""));
        et2.setText(sharedpreferences.getString(secname,""));



    }

    public void greetuser(View view) {

        TextView tv=(TextView )findViewById(R.id.tvgreetuser);
        String  name1=et1.getText().toString();
        String name2=et2.getText().toString();
        tv.setText("namasthe  "+name1+"  "+name2);
        Animation shake = AnimationUtils.loadAnimation(greet_user.this, R.anim.shake);

        tv.startAnimation(shake);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(Name, name1);
        editor.putString(secname, name2);
        editor.commit();
    }
}
