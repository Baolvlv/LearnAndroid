package com.example.bwx.viewpagedemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by bwx on 2017/2/11.
 */

public class WelcomeAct extends Activity {

    //设置延时时间
    private static final int TIME = 2000;
    //设置代表跳转到不同页面的常量值
    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE =1001;

    //设置是否为第一次进入的布尔变量
    private boolean isFirstIn = false;


    //实例化handler，判断信息的类型进行相应的跳转
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        init();
    }

    //初始化函数
    private void init(){
        //通过SharedPreference储存isFirst数据,初值为true
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        isFirstIn = preferences.getBoolean("isFirstIn",true);


        //如果不是初次进入，通过handler发送GO_HOME类型的，TIME延迟的信息
        if(!isFirstIn){
            handler.sendEmptyMessageDelayed(GO_HOME,TIME);

        }else {
            //如果初次进入，通过handler发送GO—_GUIDE类型的，TIME延迟的信息
            handler.sendEmptyMessageDelayed(GO_GUIDE,TIME);
            //通过editor修改isFirstIn的储存内容，然后提交修改
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstIn",false);
            editor.commit();


        }
    }

    private void goHome(){
        Intent i = new Intent(WelcomeAct.this,MainActivity.class);
        startActivity(i);
        finish();
    }

    private void goGuide(){
        Intent i = new Intent(WelcomeAct.this,Guide.class);
        startActivity(i);
        finish();
    }
}
