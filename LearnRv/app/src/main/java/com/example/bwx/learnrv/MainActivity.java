package com.example.bwx.learnrv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rv = new RecyclerView(this);
        setContentView(rv);//将RV作为activity的内容布局

        //设置recyclerview的布局(线性布局)
        //rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //表格布局
        rv.setLayoutManager(new GridLayoutManager(this,3));
        //给RV填充内容
        rv.setAdapter(new MyAdapter());

    }

}
