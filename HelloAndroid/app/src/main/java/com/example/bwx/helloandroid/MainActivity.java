package com.example.bwx.helloandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        //setContentView(R.layout.my_layout);
        //findViewById(R.id.btnStartAnotherAty).setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick (View v){
            //startActivity(new Intent(MainActivity.this,AnotherAty.class));
            //打开一个网页
            //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://baidu.com")));
            //}
            //});


        System.out.println("A onCreate");

        findViewById(R.id.btnStartBAty).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this,BAty.class));

                                                               }
        });



        }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("A onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("A onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("A onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("A onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.print("A onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("A onRestart");
    }

}

