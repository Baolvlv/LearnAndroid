package com.example.bwx.pushtorefresh;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView lv;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (PullToRefreshListView) findViewById(R.id.myLv);

        //使用集合存储数据
        List<String> ls = new ArrayList<>();
        ls.add("bss");
        ls.add("love");
        ls.add("WaterMelon");


        adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item
                ,ls);

        lv.setAdapter(adapter);

        //添加饰件监听器，实现载入的动画效果
        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {


                //实现下拉刷新的异步操作
                new AsyncTask() {
                    //实现后台休眠3秒
                    @Override
                    protected Object doInBackground(Object[] params) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    //实现休眠后的操作
                    @Override
                    protected void onPostExecute(Object o) {
                        adapter.addAll("goodNight","forever");
                        //通知listView更新成功
                        lv.onRefreshComplete();
                    }
                }.execute();


            }
        });
    }
}
