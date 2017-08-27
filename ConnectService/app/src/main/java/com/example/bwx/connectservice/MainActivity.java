package com.example.bwx.connectservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private EditText etData;
    private MyService.Binder binder = null;
    private TextView tvOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = (EditText) findViewById(R.id.etData);
        tvOut = (TextView) findViewById(R.id.tvOut);

        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnBindService).setOnClickListener(this);
        findViewById(R.id.btnUnBindService).setOnClickListener(this);
        findViewById(R.id.btnSyncData).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartService:
                Intent i = new Intent(this,MyService.class);
                i.putExtra("data",etData.getText().toString());
                startService(i);
                break;

            case  R.id.btnStopService:
                stopService(new Intent(this,MyService.class));
                break;

            case R.id.btnBindService:
                bindService(new Intent(this,MyService.class),this,Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnBindService:
                unbindService(this);
                break;
            case R.id.btnSyncData:
                while (binder!= null){
                    binder.setData(etData.getText().toString());
                }
                break;
        }
    }

    @Override
    //IBinder为MyService类的onBinder函数的返回值
    public void onServiceConnected(ComponentName name, IBinder service) {
        binder= (MyService.Binder) service;
        binder.getService().setCallback(new MyService.Callback() {
            @Override
            public void onDataChange(String Data) {
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("data",Data);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        });

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tvOut.setText(msg.getData().getString("data"));
        }
    };


}
