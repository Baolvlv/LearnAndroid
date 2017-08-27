package com.example.bwx.learncontext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   // private TextView tv;
    private  TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("Main Activity onCreate");
//
//        tv = new TextView(this);
//        //tv.setText("hello bss");
//        //重载函数可以传入资源id
//        tv.setText(R.string.hello_bss);
//
//        System.out.println(getResources().getText(R.string.hello_bss));
//
//        //  使ContentView直接显示TextView
//        setContentView(tv);

        //使用ImageView呈现图标资源

//        ImageView iv = new ImageView(this);
//        iv.setImageResource(R.mipmap.ic_launcher);
//        setContentView(iv);
        setContentView(R.layout.main1);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);

        textView.setText("共享的数据是："+getApp().getTextData());


        findViewById(R.id.btnSaveData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取信息保存在全局Context
                ((App)getApplicationContext()).setTextData(editText.getText().toString());

                textView.setText("共享的数据是："+editText.getText().toString());


            }
        });



    }
    public App getApp(){
        return (App) getApplicationContext();
    }
}
