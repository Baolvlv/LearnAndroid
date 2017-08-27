package com.example.usingasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.webText);
        btn = (Button) findViewById(R.id.btnRead);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注意网址为https
                readURL("https://www.baidu.com");
            }
        });

    }

    public void readURL(String Url){
        //参数为异步开始时的参数，执行过成中的参数，执行结束后的参数
        //开始的参数为doInBackground的参数，返回值为执行结束后的参数，执行过程中的参数为执行进度
        new AsyncTask<String,Float,String>() {


            //doInBackground中只能执行不涉及ui的操作，与ui线程的互动在回调函数中执行
            @Override
            protected String doInBackground(String... params) {
                try {
                    //创建Url对象
                    URL url = new URL(params[0]);
                    //打开Url的网络连接
                   URLConnection connection = url.openConnection();
                    //获取当前链接读取内容的全部长度
                    long total = connection.getContentLength();
                    //由connection获取输入流，之后按普通读写操作读取网页数据
                    InputStream is = connection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String line;
                    StringBuffer sb = new StringBuffer();
                    while ((line = br.readLine()) != null){
                        sb.append(line);

                        //使用当前读取长度除以总长度作为数据，发布读取进度
                        publishProgress((float)(sb.toString().length()/total));
                    }
                    br.close();
                    isr.close();
                    is.close();

                    return sb.toString();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

           //AsyncTask的doBackGround执行之前执行
            @Override
            protected void onPreExecute() {

                Toast.makeText(MainActivity.this,"开始读取", Toast.LENGTH_SHORT).show();

                super.onPreExecute();
            }

            //当前的AsyncTask执行完后，执行此方法，参数为doInBackGround的返回值
            @Override
            protected void onPostExecute(String s) {

                tv.setText(s);

                super.onPostExecute(s);
            }

            //执行过程中对外发布执行的进度
            //参数为publishProgress的返回值
            @Override
            protected void onProgressUpdate(Float...values) {
                Log.i("progress",values[0].toString());
                super.onProgressUpdate(values);
            }


           //取消AsyncTask时执行
            @Override
            protected void onCancelled(String s) {
                super.onCancelled(s);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }

        }.execute(Url);

    }
}
