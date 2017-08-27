package com.example.bwx.learnhttp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private ListView lv;
    private ArrayAdapter<String> adapter;


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
                            URLConnection connection = url.openConnection();
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
                }.execute("http://fanyi.youdao.com/openapi.do?keyfrom=baolvlvLearnHttp&key=1094693720&type=data&doctype=json&version=1.1&q="+et.getText());
            }
        });
    }
}
