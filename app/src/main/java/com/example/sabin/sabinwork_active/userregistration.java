package com.example.sabin.sabinwork_active;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sabin.sabinwork_active.util.Agecalculator;

public class userregistration extends AppCompatActivity {
 private EditText email;
    private RadioGroup gen;
    public EditText persone_name;
    private EditText pswd1;
    public EditText pswd2;
    private EditText etdob;
    private TextView tvDisplayDate;
    public static int age;

/*
    private static String sname;
    private static String gender;

    private static String spassword;
    private static String semail; */
    private static String sdob;
    private static boolean staus;
    public static final String file="mydata";





    private SharedPreferences sharePref;

    //shargede data:
    static final String MyPREFERENCES = "MyPrefs";
    public static String Name="User_Name";
    public static String Password="Password";
    public static String Gender="gender";

    public static String Email="Email";
    public static String Dob="Dob";
    public static String Key="Key";
    public static  String verify="verify";



//validation part

    public void validation(View view) {
        String a = pswd1.getText().toString();
        String b = pswd2.getText().toString();
        this.sdob = etdob.getText().toString();


        try {
            age = Agecalculator.AgeCalc(sdob);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO Auto-generated method stub

        //Validation for Blank Field
        if (persone_name.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(), "Name cannot be Blank", Toast.LENGTH_LONG).show();
            persone_name.setError("Name cannot be Blank");
            return;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            //Validation for Invalid Email Address
            Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG).show();
            email.setError("Invalid Email");
            return;
        } else if (!a.equals(b)) {

            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
            pswd2.setError("Password does not match");
        } else if (age < 13) {

            Toast.makeText(getApplicationContext(), "U AGE IS LESS THAN 13" + age, Toast.LENGTH_SHORT).show();

        }

           /* else if(!android.util.Patterns.DOMAIN_NAME.matcher(et3.getText().toString()).matches())
            {
                //Validation for Website Address
                Toast.makeText(getApplicationContext(), "Invalid Website", Toast.LENGTH_LONG).show();
                et3.setError("Invalid Website");
                return;
            }  */
        else {
            sharePref=getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
            SharedPreferences.Editor editor=sharePref.edit();
            editor.putString(Name,persone_name.getText().toString());
            editor.commit();
            editor.putString(Password,pswd2.getText().toString());
            editor.commit();
            editor.putString(Email,email.getText().toString());
            editor.commit();
            editor.putString(Dob,sdob);
            editor.commit();
          //  editor.putString(Key,Code);
            editor.commit();
            editor.putBoolean(verify,false);
            editor.commit();
            Toast.makeText(getApplicationContext(), "Validated Succesfully"+sharePref.getString(Name,"")+"  "+sharePref.getString(Password,""), Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getBaseContext(),login_main.class);
            startActivity(intent);
            finish();
/*

      //  Properties props = new Properties();
        try {
            sname = persone_name.getText().toString();
            spassword = pswd1.getText().toString();
            semail = email.getText().toString();
            this.sdob = etdob.getText().toString();

        }catch (NullPointerException e){
            e.printStackTrace();
        }
        int i=12345+(int)(Math.random()*99999);

        String Code=Integer.toString(i);

        /*SharedPreferences.Editor editor=sharePref.edit();
        editor.putString(Name,sname);
        editor.commit();
        editor.putString(Password,spassword);
        editor.commit();
        editor.putString(Email,semail);
        editor.commit();
        editor.putString(Dob,sdob);
        editor.commit();
        editor.putString(Key,Code);
        editor.commit();
        editor.putBoolean(verify,false);
        editor.commit();
        String sub="Your email verivcation key";
        String body="this OTP for your app"+Code;
        try {
          //  staus = Mailmanager_send.sent(semail,sub,body);
        }
        catch (Exception e){
            Toast.makeText(this,"cheack internet connection",Toast.LENGTH_LONG).show();
        }

        if(staus==true){
            Toast.makeText(this,"OTP Sumited ",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"cheack internet connection",Toast.LENGTH_LONG).show();
        }
    }



*/


        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregistration);
       email=(EditText)findViewById(R.id.etEmailAddress);
        persone_name=(EditText)findViewById(R.id.etPersonName);
        pswd1=(EditText)findViewById(R.id.etPassword);
        pswd2=(EditText)findViewById(R.id.etrepeatPassword);
        etdob=(EditText)findViewById(R.id.etdate);
        gen= (RadioGroup)findViewById(R.id.rggender);


    }



}
