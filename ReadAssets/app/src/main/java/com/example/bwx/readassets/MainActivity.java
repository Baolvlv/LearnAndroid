package com.example.bwx.readassets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    //用于读取的Tag标签
    private static final String TAG = "ReadAssets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnReadTxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //通过getAssets获取InputStream获取字节流
                    InputStream is = getResources().getAssets().open("info.txt");
                    //将字节流转换为字符流
                    InputStreamReader isr = new InputStreamReader(is,"UTF-8");
                    //创建带缓冲区的字符流
                    BufferedReader bfr = new BufferedReader(isr);
                    //逐行循环读取文件
                    String in ="";
                   while((in = bfr.readLine()) != null){
                       Log.i(TAG,in);
                   }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
