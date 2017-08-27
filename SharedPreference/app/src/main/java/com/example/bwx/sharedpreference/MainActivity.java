package com.example.bwx.sharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final String KEY = "MyValue";

    private EditText et;
    //声明的sharedPreference
    SharedPreferences preferences;
    //声明sharedPreference的editor
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);

        findViewById(R.id.btnRead).setOnClickListener(this);
        findViewById(R.id.btnWrite).setOnClickListener(this);

        //获取当前Activity的sharedPreference,onCreate函数之前不能调用getPreference
        preferences = getPreferences(Activity.MODE_PRIVATE);
        //创建preference的editor对象
        editor = preferences.edit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnWrite:
                editor.putString(KEY,et.getText().toString());
                if(editor.commit()){
                    Toast.makeText(getApplicationContext(),"写入成功",Toast.LENGTH_SHORT)
                    .show();
                }
                break;
            case R.id.btnRead:
                //第二个参数为当前键不存在时，其默认的值
                String in = preferences.getString(KEY,"当前值不存在");
                Toast.makeText(getApplicationContext(),in,Toast.LENGTH_SHORT)
                .show();
                break;
        }

    }
}
