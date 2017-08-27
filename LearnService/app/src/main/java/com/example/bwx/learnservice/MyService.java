package com.example.bwx.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    //在外界执行startService之后执行
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                while (true) {
//                    System.out.println("服务正在运行...");
//
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();

        return super.onStartCommand(intent, flags, startId);


    }
}
