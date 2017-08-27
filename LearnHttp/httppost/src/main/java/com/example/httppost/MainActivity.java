package com.example.httppost;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private ListView lv;
    private ArrayAdapter<String> adapter;
    private String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        lv = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1);

        findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String,Void,String>(){

                    @Override
                    protected String doInBackground(String... params) {
                        try {
                            //用参数中的url创建url对象
                            URL url =  new URL(params[0]);
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                            //配置connection,使当前的connection可以向服务器输出数据
                            connection.setDoOutput(true);
                            // connection.setDoInput默认为true
                            connection.setDoInput(true);
                            //设置connection当前的请求方式
                            connection.setRequestMethod("POST");

                            //获取输出流
                            OutputStream os = connection.getOutputStream();
                            //创建writer
                            OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
                            //创建带缓冲区的writer,可以写入行
                            BufferedWriter bw = new BufferedWriter(osw);
                            bw.write("keyfrom=baolvlvLearnHttp&key=1094693720&type=data&doctype=json&version=1.1&q="+result);
                            bw.flush();

                            //字节流
                            InputStream is =  connection.getInputStream();
                            //指定编码方式，字节流转字符流
                            InputStreamReader isr  =new InputStreamReader(is,"UTF-8");
                            //带缓冲区的reader
                            BufferedReader br  =new BufferedReader(isr);
                            String line;
                            StringBuffer sb = new StringBuffer();

                            while ((line = br.readLine()) != null){
                                sb.append(line);
                            }
                            br.close();
                            isr.close();
                            is.close();
                            //读写完成后返回字符串
                            return sb.toString();

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }


                    @Override
                    protected void onPreExecute() {
                        result = et.getText().toString();
                        super.onPreExecute();
                    }

                    @Override
                    protected void onPostExecute(String s) {

                        try {
                            JSONObject root = new JSONObject(s);
                            JSONObject basic = root.getJSONObject("basic");
                            adapter.add("音标："+basic.getString("phonetic"));
                            adapter.add("基本解释：");
                            JSONArray explains = basic.getJSONArray("explains");
                            for (int i=0;i<explains.length();i++){
                                adapter.add(explains.getString(i));
                            }
                            lv.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        super.onPostExecute(s);
                    }
                }.execute("http://fanyi.youdao.com/openapi.do");
            }
        });
    }
}
