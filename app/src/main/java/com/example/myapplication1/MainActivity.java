package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate()");

        EditText etPerson1Name = (EditText) findViewById(R.id.etPerson1Name);
        EditText etPerson2Name = (EditText) findViewById(R.id.etPerson2Name);
        Button btnFlames = (Button) findViewById(R.id.btnFlames);
        TextView tvFlamesResult = (TextView) findViewById(R.id.tvFlamesResult);

        btnFlames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Flames button is clicked");
                tvFlamesResult.setText("");
                String person1Name = etPerson1Name.getText().toString();
                String person2Name = etPerson2Name.getText().toString();

                if(person1Name.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Please enter person 1 name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(person2Name.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Please enter person 2 name", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d(TAG, "person 1 = " + person1Name + " & person 2 = " + person2Name);

                String flamesResult = calculateFlames(person1Name, person2Name);

                tvFlamesResult.setText(flamesResult);
            }
        });
    }

    private String calculateFlames(String person1,String person2){
      //  String name1 =person1;
      //  String name2 =person2;
        String s=person1;
        String s1=person2;
        String r="";
        char e='\0';
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            //System.out.println(c);
            String ss = Character.toString(c);
            if(s1.contains(ss)) {
                s1=s1.replaceFirst(ss, "");
            }
            else {
                r+=ss;
            }
        }
        r+=s1;
        int k=6,l=0;
        String s3="FLAMES";
        while(k>1)
        {
            for(int m=1;m<r.length();m++)
            {
                if(s3.charAt(l)!='X')
                {
                    l++;
                    if(l==6)
                        l=0;
                }
                else
                {
                    l++;
                    if(l==6)
                        l=0;
                    m--;
                }
            }
            while(s3.charAt(l)=='X')
            {
                l++;
                if(l==6)
                    l=0;
            }
            s3=s3.substring(0,l)+"X"+s3.substring(l+1);
            k--;
        }

        for(int i=0;i<s3.length();i++)
        {
            if(s3.charAt(i)!='X')
                e=s3.charAt(i);
        }
        String result="";
        if(e=='F'){
            result="Friends";
        }
        if(e=='L'){
            result="Love";
        }
        if(e=='A'){
            result="Affection";
        }
        if(e=='M'){
            result="Marriage";
        }
        if(e=='E'){
            result="Enemies";
        }
        if(e=='S'){
            result="Sister";
        }
        return result;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
    public void simple(){

    }
}