package com.example.bwx.lanchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Baty extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baty);

        tv=(TextView) findViewById(R.id.tv);
        tv.setText(String.format("TaskID:%d\n,Current Activity ID:%s",getTaskId(),toString()));

        findViewById(R.id.btnStartMainAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Baty.this,MainActivity.class));
            }
        });

        findViewById(R.id.btnStartBaty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Baty.this,Baty.class));
            }
        });

    }
}
