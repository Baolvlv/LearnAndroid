package com.example.bwx.useexternalstorage;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et;
    private TextView tv;

    public static final String FILE_NAME = "MyCreate.txt";
    //定义一个储存在ExternalStorage的public的文件，参数必须为特定的文件类型：DIRECTORY_MUSIC 或者 DIRECTORY_PICTURES
    File sdcard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    //在外部储存private的根目录下新建文件夹pictures
    String filePath = Environment.getExternalStorageDirectory()+"/Pictures";

    //以FILE_NAME在路径下新建myFile
    File myFile = new File(filePath,FILE_NAME);
    File testFile = new File(filePath);


    //判断是否请求外部储存权限
    protected boolean shouldAskPermissions() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    //当最小sdk小于23时，请求外部储存权限
    @TargetApi(23)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);

        findViewById(R.id.btnReadData).setOnClickListener(this);
        findViewById(R.id.btnWriteData).setOnClickListener(this);
        findViewById(R.id.btnTest).setOnClickListener(this);

        //判断是否请求外部储存权限
        if (shouldAskPermissions()) {
            askPermissions();
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnReadData:
                // 判断设备sd卡是否存在
                if(!sdcard.exists()){
                    Toast.makeText(getApplicationContext(),"sd卡不存在",Toast.LENGTH_SHORT).show();
                    return;
                }

                //文件不存在创建文件
                if (!myFile.exists()) {
                    try {
                        myFile.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    FileInputStream fis = new FileInputStream(myFile);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    //StringBuilder储存所有数据
                    StringBuilder strBuilder = new StringBuilder();
                    //临时变量储存每行数据
                    String line = "";
                    while ((line = br.readLine()) != null) {
                        //不为空，不断追加
                        strBuilder.append(line);
                    }
                    br.close();
                    isr.close();
                    fis.close();
                    Toast.makeText(MainActivity.this, "数据读取成功", Toast.LENGTH_SHORT).show();
                    tv.setText(strBuilder);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case  R.id.btnWriteData:
                // 判断设备sd卡是否存在
                if(!sdcard.exists()){
                    Toast.makeText(getApplicationContext(),"sd卡不存在",Toast.LENGTH_SHORT).show();
                    return;
                }

                //文件不存在创建文件
                if(!myFile.exists()){
                    try {
                        myFile.createNewFile();
                    } catch (IOException e) {
                        Log.e("文件创建失败",e.getMessage());
                        e.printStackTrace();
                    }
                }
                //文件写入操作
                try {
                    FileOutputStream fos = new FileOutputStream(myFile);
                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    osw.write(et.getText().toString());
                    osw.flush();
                    fos.flush();
                    osw.close();
                    fos.close();
                    Toast.makeText(getApplicationContext(),"数据写入成功",Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    Log.e("文件没找到",e.getMessage());
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.e("io错误",e.getMessage());
                    e.printStackTrace();
                }
                break;
            case R.id.btnTest:
                if(testFile.exists()){
                    Toast.makeText(getApplicationContext(),"Pictures文件存在",Toast.LENGTH_SHORT).show();
                    try {
                        new File(testFile+"/NewFile.txt").createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Pictures文件不存在",Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }
}
