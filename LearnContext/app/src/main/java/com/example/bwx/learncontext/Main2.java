package com.example.bwx.learncontext;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by bwx on 2016/9/29.
 */
public class Main2 extends Activity {
    private TextView textView;
    private  EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        
        System.out.println("Main2 onCreate");

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
