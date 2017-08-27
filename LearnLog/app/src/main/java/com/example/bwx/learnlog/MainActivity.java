package com.example.bwx.learnlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    //设置标签，指明从哪个activity中输出
    private static String TAG ="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        System.out.println("普通日志Info");
//        System.err.println("错误日志Warn");
        Log.e(TAG,"错误信息");
        Log.w(TAG,"警告信息");
        Log.i(TAG,"普通信息");
        Log.d(TAG,"调试信息");
        Log.v(TAG,"无用信息");
        Log.e("MSG","其他信息");
    }
}
