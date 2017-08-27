package com.example.bwx.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    //设置notificationID
    public static final int NOTIFICATION_ID = 1200;
    //设置计数器
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btnShowNotification);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //每次点击时，计数器加1
                counter++;

                //创建notification前，需要先创建一个builder,通过builder创建一个真正的notification
                NotificationCompat.Builder builder = new NotificationCompat
                        .Builder(MainActivity.this);

                //通过builder为当前的notification指定属性
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("你有"+counter+"条新消息！");
                builder.setContentText("天空一无所有，为何给我安慰");

                //调用build方法创建notification的真实对象
                Notification notification = builder.build();

                //获取系统的notification服务，传递给manager用来在通知栏显示
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                //通过固定的notificationID对当前的notification进行更新，manager进行提示
                manager.notify(NOTIFICATION_ID,notification);

            }
        });
    }
}
