package com.example.bwx.testjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        try {
//            InputStreamReader isr = new InputStreamReader(getAssets().open("test.json"),"UTF-8");
//            BufferedReader br = new BufferedReader(isr);
//            String line;
//            StringBuffer sb = new StringBuffer();
//            while ((line = br.readLine())!= null){
//                sb.append(line);
//            }
//            br.close();
//            isr.close();
//
//            //创建JSONObject对象
//            JSONObject root = new JSONObject(sb.toString());
//            Log.i("root","cat:"+root.getString("cat"));
//            //通过JSON对象获得JSON数组
//            JSONArray ja = root.getJSONArray("language");
//            for (int i=0;i<ja.length();i++){
//                //获取json数组中的json对象
//                JSONObject lan = ja.getJSONObject(i);
//                Log.i("room","--------------------");
//                //获取json对象中的各种值
//                Log.i("lan","id:"+lan.getInt("id"));
//                Log.i("lan","ide:"+lan.getString("ide"));
//                Log.i("lan","name:"+lan.getString("name"));
//
//            }
//
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        try {

            JSONObject root = new JSONObject();

            JSONObject lan1 = new JSONObject();
            //为对象添加属性
            lan1.put("id",1);
            lan1.put("ide","Eclipse");
            lan1.put("name","java");

            JSONObject lan2 = new JSONObject();
            lan2.put("id",2);
            lan2.put("ide","Xcode");
            lan2.put("name","Swift");

            JSONObject lan3 = new JSONObject();
            lan3.put("id",3);
            lan3.put("ide","Visual Studio");
            lan3.put("name","C#");
            //创建JSON数组
            JSONArray ja = new JSONArray();
            ja.put(lan1);
            ja.put(lan2);
            ja.put(lan3);

            //将数组添加为根对象属性
            root.put("language",ja);
            //第二个参数为Object,String对象本身为为Object
            root.put("cat","it");
            //将根对象转为String输出
            Log.i("print",root.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
