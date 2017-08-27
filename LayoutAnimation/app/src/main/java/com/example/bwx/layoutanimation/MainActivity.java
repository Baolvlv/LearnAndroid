package com.example.bwx.layoutanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       if(savedInstanceState ==null){
           getSupportFragmentManager()
                   .beginTransaction()
                   .replace(R.id.activity_main,new ExampleFragment())
                   .commit();
       }




    }

}



