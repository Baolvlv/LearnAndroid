package com.example.bwx.readwriteinternaldata;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    private String flieName = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        tv  = (TextView) findViewById(R.id.tv);

        findViewById(R.id.btnReadData).setOnClickListener(this);
        findViewById(R.id.btnWriteData).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnReadData:
                try {
                    //openFileInput()只有一个参数，即需要读取的文件名
                    FileInputStream fis = openFileInput(flieName);
                    //包装成为InputStreamReader,可调用read方法
                    InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
                    //创建字符数组，通过fis.available()获取字符流中可用字符的长度
                    char input[] = new char[fis.available()];
                    //将字符流读入字符数组
                    isr.read(input);
                    isr.close();
                    fis.close();
                    //将字符数组转为String
                    String text = new String(input);
                    //将string设置为TextView的内容
                    tv.setText(text);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnWriteData:
                try {
                    //文件输出流，第二个参数为写入模式,使用openFileOutPut()方法输出的文件在
                    //应用程序内部储存空间
                    FileOutputStream fos = openFileOutput(flieName, Context.MODE_PRIVATE);
                    //将文件输出流进一步包装，变为可写入字符串的OutPutStreamWriter
                    OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
                    osw.write(et.getText().toString());
                    //执行flush操作，将缓冲区的数据全部输出
                    osw.flush();
                    fos.flush();
                    //关闭流，后打开的流先关闭
                    osw.close();
                    fos.close();
                    Toast.makeText(MainActivity.this,"写入完成",Toast.LENGTH_SHORT).show();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
