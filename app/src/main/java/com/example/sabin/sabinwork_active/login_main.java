package com.example.sabin.sabinwork_active;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sabin.sabinwork_active.util.ShakeeventListner;

public class login_main extends AppCompatActivity {
private EditText pername;
    private EditText pswd;
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    public static String Name="User_Name";
    public static String Password="Password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        pername=(EditText)findViewById(R.id.etuname);
        pswd=(EditText)findViewById(R.id.etpswd);
        //startService()
        Intent inten = new Intent(getBaseContext(),ShakeeventListner.class);
        getBaseContext().startService(inten);
        try{
            sharedPreferences=getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
            String uname=sharedPreferences.getString(Name,"");
            pername.setText(uname);
        }
        catch (Exception e){}
    }


    public void do_login(View view) {

        String pswd1=sharedPreferences.getString(Password,"");
       // Toast.makeText(getBaseContext(), pswd1, Toast.LENGTH_SHORT).show();
String password1=pswd.getText().toString();
        if(password1.equals(pswd1)){
            Toast.makeText(getBaseContext(), "hi user", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getBaseContext(),intent.class);
            startActivity(intent);
            finish();

        }
       else {
            Toast.makeText(getBaseContext(), "Enter valid username and password", Toast.LENGTH_SHORT).show();


        }}
    public void intent_signup(View view) {
        Intent intentfuncrionA = new Intent(getBaseContext(), userregistration.class);
        startActivity(intentfuncrionA);
    }
}
