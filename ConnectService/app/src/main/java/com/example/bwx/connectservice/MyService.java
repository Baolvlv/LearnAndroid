package com.example.bwx.connectservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    private boolean running = false;
    private String data = "这是默认信息";

    public MyService() {
    }


    //接收Intent传递的数据
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        data = intent.getStringExtra("data");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    public class Binder extends android.os.Binder
    {
        //通过添加方法修改MyService中Data的值
        public void setData(String Data){
            MyService.this.data = Data;
        }
        //通过添加getService方法传递当前类
        public MyService getService(){
            return  MyService.this;
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        running=true;

        new Thread(){
            @Override
            public void run() {
                super.run();
                int i = 0;
                
                while (running){

                    i++;

                    String str = i + ":"+data;
                    System.out.println(str);

                    if (callback!=null){
                        callback.onDataChange(str);
                    }

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {

        super.onDestroy();

        running = false;
    }

    //实例化变量
    private Callback callback = null;


    //设置get,set方法
    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }
    //创建接口
    public static interface Callback{
        void onDataChange(String Data);
    }
}
