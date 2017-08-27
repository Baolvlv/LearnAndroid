package com.example.bwx.actionbarusing;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private String[] myString ={"aaaaa","bss","watermelon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //将工具栏设为Activity的应用栏
        Toolbar myToolBar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolBar);

        //为Activity设置向上button
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //为ActionBar扩展菜单项
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions, menu);

        //查找到searchView的Action
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);

        //设置listView
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1
                ,myString));
        //设置列表的文本过滤器
        lv.setTextFilterEnabled(true);

        //设置默认提示文本
        searchView.setQueryHint("查找");


        //设置searchView的事件监听器
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //此方法执行实际的查询

            //提交查询文本的方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                //实际应用中应该在该方法内执行实际查询
                //此处仅使用Toast显示用户输入的查询内容
                Toast.makeText(MainActivity.this, "您选择的是："+query, Toast.LENGTH_SHORT).show();
                return true;
            }

            //查询文本改变时执行的方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText)){
                    //  清除过滤
                    lv.clearTextFilter();
                }else{
                    //根据用户内容进行过滤
                    lv.setFilterText(newText);
                }
                return true;
            }
        });




        //查找到分享ActionBar，并设置分享内容
        MenuItem shareItem = menu.findItem(R.id.action_share);
        ShareActionProvider mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        mShareActionProvider.setShareIntent(getDefaultIntent());


        return super.onCreateOptionsMenu(menu);
    }

    //调用程序中所有发送图片的应用程序
    private Intent getDefaultIntent(){
        //设置为发送信息的intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        //设置intent的发送类型为图片
        intent.setType("image/*");
        return intent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //为操作按钮添加响应事件
        switch (item.getItemId()){
            case R.id.action_search:
//                WebView wb = (WebView) findViewById(R.id.searchView);
//                wb.loadUrl("http://baidu.com");
                return true;
            case R.id.action_settings:
                Toast.makeText(MainActivity.this,"setting",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
