package com.example.bwx.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baty);
        System.out.println("B onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("B onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("B onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("B onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("B onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.print("B onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("B onRestart");
    }

}
