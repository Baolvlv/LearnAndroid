package com.example.bwx.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tv;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //tv = (TextView) findViewById(R.id.tv);

        editText = (EditText) findViewById(R.id.editText);

        Intent i = getIntent();
//       // Bundle data =i.getExtras();
//        Bundle data = i.getBundleExtra("data");
        //tv.setText(i.getStringExtra("data"));

        //tv.setText(String.format("name=%s,age=%d,name1=%s",data.getString("name"),data.getInt("age"),data.getString("name1","bss")));
        //User user= (User) i.getSerializableExtra("user");
       // User user= (User) i.getParcelableExtra("user");
        //tv.setText(String.format("User info(name=%s,age=%d)",user.getName(),user.getAge()));

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("data",editText.getText().toString());
                setResult(1,i);//状态结果1和返回值
                //结束当前activity
                finish();

            }
        });
    }
}
