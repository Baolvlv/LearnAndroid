package com.example.bwx.learnhttpclient;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private TextView tv;
    

    //声明HttpClient
    HttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //实例化HttpClient
        client = new DefaultHttpClient();
        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //readNet("http://10.0.2.2:8080/MyWebTest/Do?name="+et.getText());
                //readNet("http://10.0.2.2:8080/MyWebTest/Do?name=","name="+et.getText());
                readNet("http://10.0.2.2:8080/MyWebTest/Do?name=",et.getText().toString());
            }
        });
    }

    public void readNet(String Url,String in){
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... params) {

                //获取数组中的第一个参数，为真实的url
                String urlString  = params[0];
                //创建HttpGet对象，HttpGet继承自HttpRequest
                //HttpGet get = new HttpGet(urlString);

               //创建httpPost对象
                HttpPost post = new HttpPost(urlString);
                try {

                    //基础键值对
                    List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
                    list.add(new BasicNameValuePair("name",params[1]));
                    //将list转为Entity
                    post.setEntity(new UrlEncodedFormEntity(list));

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }


                try {
                    //HttpClient执行HttpGet获得HttpResponse对象
                   //HttpResponse response =  client.execute(get);
                    //通过response.getEntity()获取get请求中读取的互联网数据
                    //通过EntityUti.toString()将得到的结果转化为String
                    HttpResponse response =  client.execute(post);
                    String value = EntityUtils.toString(response.getEntity());

                    return value;

                } catch (IOException e) {
                    e.printStackTrace();
                }


                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                tv.setText(s);

            }
        }.execute(Url,in);

    }


}
