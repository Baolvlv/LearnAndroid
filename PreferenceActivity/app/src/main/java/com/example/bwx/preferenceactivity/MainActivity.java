package com.example.bwx.preferenceactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvList,tvCheck,tvEdit;
    private Button btnShow,btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }


    private void initview(){
        btnSet = (Button) findViewById(R.id.btnSetting);
        btnShow  = (Button) findViewById(R.id.btnShow);
        btnSet.setOnClickListener(this);
        btnShow.setOnClickListener(this);

        tvList = (TextView) findViewById(R.id.tv_list);
        tvCheck = (TextView) findViewById(R.id.tv_check);
        tvEdit = (TextView) findViewById(R.id.tv_edit);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSetting:
                startActivity(new Intent(getApplicationContext(),Setting.class));
                break;
            case R.id.btnShow:
                showInfo();
                break;
        }

    }

    private void showInfo(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        tvCheck.setText(sp.getBoolean(Keys.CHECK_KEY,false)+"");
        tvEdit.setText(sp.getString(Keys.EDIT_KEY,"text"));
        tvList.setText(sp.getString(Keys.LIST_KEY,"list"));
    }
}
