package com.example.bwx.mysocketclient;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etIp,etSend;
    TextView tvChat;
    String ip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etIp = (EditText) findViewById(R.id.etIP);
        ip = etIp.getText().toString();
        etSend = (EditText) findViewById(R.id.etSend);
        tvChat = (TextView) findViewById(R.id.tvChat);

        findViewById(R.id.btnConnect).setOnClickListener(this);
        findViewById(R.id.btnSend).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnConnect:
                connect();
                break;
            case R.id.btnSend:
                send();
                break;
        }

    }

   //-----------------socket相关代码------------------------
    Socket socket = null;
    BufferedWriter writer = null;
    BufferedReader reader = null;

    public void connect(){


            //读取聊天信息的异步线程
            AsyncTask<Void,String,Void> read = new AsyncTask<Void, String, Void>() {
                @Override
                protected Void doInBackground(Void... params) {


                    try {
                        //socket不能在主线程中
                       //新建socket,参数为ip与端口号
                        socket = new Socket(ip,12346);
                        //通过socket的输入输出流,创建BufferedWriter与BufferedReader
                        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                       //向外发布成功的状态
                        publishProgress("@success");
                    } catch (IOException e) {
                        Toast.makeText(getApplicationContext(),"无法建立连接",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }


                    try {
                        String line;
                        //通过reader读取数据并向外发布
                        while ((line = reader.readLine())!= null){
                            publishProgress(line);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onProgressUpdate(String... values) {
                    //接收判断，如果是成功，则弹出提示
                    if(values[0].equals("@success")){
                        Toast.makeText(MainActivity.this,"连接成功",Toast.LENGTH_SHORT).show();
                    }

                    //在主ui线程中，更新接收到的消息
                    tvChat.append("某人说："+values[0]+"\n");
                    super.onProgressUpdate(values);
                }
            };

            //调用异步线程执行
            read.execute();


    }

    public void send(){
        try {
            tvChat.append("我说："+etSend.getText().toString()+"\n");
            //通过writer输出信息
            writer.write(etSend.getText().toString()+"\n");
            writer.flush();
            //清空ediText的内容
            etSend.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
