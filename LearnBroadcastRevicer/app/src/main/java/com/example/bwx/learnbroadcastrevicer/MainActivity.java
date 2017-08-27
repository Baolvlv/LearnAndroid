package com.example.bwx.learnbroadcastrevicer;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSendMsg).setOnClickListener(this);
        findViewById(R.id.btnReg).setOnClickListener(this);
        findViewById(R.id.btnUnreg).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSendMsg:
                //发送消息
                //Intent i = new Intent(this,MyReceiver.class);
                //创建Intent时使用隐式Intent创建
                Intent i = new Intent(MyReceiver.ACTION);
                i.putExtra("data","bss");//通过Intent附加数据并传递
                //sendBroadcast(i);发送无序的Broadcast
                //可以被中断的是有序的Broadcast,发送有序的Broadcast
                sendOrderedBroadcast(i,null);

                break;
            case R.id.btnReg:
                if(receiver == null){
                    //创建recevier并注册
                    receiver = new MyReceiver();
                    registerReceiver(receiver,new IntentFilter(MyReceiver.ACTION));
                }

                break;
            case R.id.btnUnreg:
                if(receiver != null){
                    unregisterReceiver(receiver);
                    receiver = null;
                    
                }
                break;
        }
    }

    //防止重复注册
    private MyReceiver receiver = null;
}
