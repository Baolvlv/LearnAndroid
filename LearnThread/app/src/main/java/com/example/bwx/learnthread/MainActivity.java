package com.example.bwx.learnthread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //使主线程阻塞1秒，1秒钟内界面卡顿
                    Thread.sleep(1000);
                    Log.i("sleep",">>>>>>>>>>>>>>Tick");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //创建新线程，匿名类
                new Thread(){

                    //Start方法开始后，执行run方法
                    public void run(){
                        while (true){
                            try {
                                //使新线程阻塞1秒，主线程不受影响，界面不会卡顿
                                sleep(1000);
                                Log.i("sleep",">>>>>>>>>Tick");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start();
            }
        });
    }
}
