package com.example.bwx.learncomponets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MulChose extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private CheckBox cb1,cb2,cb3,cb4;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mui_chose);

        tvResult = (TextView) findViewById(R.id.tvResult);

        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb4 = (CheckBox) findViewById(R.id.cb4);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String str = "我今天";
        if(cb1.isChecked())
        {
            str += cb1.getText() + ",";

        }
        if(cb2.isChecked())
        {
            str += cb2.getText() + ",";

        }
        if(cb3.isChecked())
        {
            str += cb3.getText() + ",";

        }
        if(cb4.isChecked())
        {
            str += cb4.getText();

        }

        tvResult.setText(str);

    }
}
