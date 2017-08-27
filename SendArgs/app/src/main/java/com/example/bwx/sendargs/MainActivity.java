package com.example.bwx.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.btnStartAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                //i.putExtra("data","hello bwx");//传数据

                //传递数据包
//                Bundle b = new Bundle();
//                b.putString("name","bwx");
//                b.putInt("age",20);
//                //i.putExtras(b);
//                i.putExtra("data",b);
                i.putExtra("user",new User("bss",20));
                //startActivity(i);只能用于普通启动
                //接收其他Activity的返回值启动
                startActivityForResult(i,0);//Intent和结果码



            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textView.setText(data.getStringExtra("data"));
    }
}
