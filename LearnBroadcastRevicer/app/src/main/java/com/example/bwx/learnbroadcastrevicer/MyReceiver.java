package com.example.bwx.learnbroadcastrevicer;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public static final String ACTION = "com.example.bwx.learnbroadcastrevicer.intent.action.MyReceiver";
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
       //如果其他的程序向接收器发送消息可以接收到,通过intent接收
        //System.out.println("接收到了消息,消息是："+intent.getStringExtra("data"));
        System.out.println("MyReceiver接收到了消息");

        //中断广播
        abortBroadcast();
    }
}
