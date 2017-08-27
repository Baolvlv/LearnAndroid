package com.example.testsqlite;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private SimpleCursorAdapter adapter;
    private ListView lv;
    private EditText etName,etSex;
    private Button btnAdd;
    private Db db;
    private SQLiteDatabase dbRead,dbWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etSex = (EditText) findViewById(R.id.etSex);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("name",etName.getText().toString());
                cv.put("sex",etSex.getText().toString());

                dbWrite.insert("user",null,cv);
                refershListview();

            }
        });



        try {
             db = new Db(this);
            dbRead = db.getReadableDatabase();
            dbWrite = db.getWritableDatabase();

            //参数：context,显示结果的布局资源，Cursor,Cursor的需要输出的数据源，输出的位置
            //SimpleCursorAdapter要求数据表中必须有_id这一列
            //初次查询Cursor可以为空
            adapter = new SimpleCursorAdapter(this,R.layout.user_list_cell
                    ,null,new String[]{"name","sex"},new int[]{R.id.tvName,R.id.tvSex});

            lv = (ListView) findViewById(R.id.list);
            //只要adapter发生改变，setAdapter()函数就执行
            lv.setAdapter(adapter);

            refershListview();


            //设置listView的item的长按事件监听器
            lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                    //弹出对话框
                    new AlertDialog.Builder(MainActivity.this).setTitle("提醒").setMessage("你确定要删除该项吗？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //通过adapter获取到Cursor,并移动到长按的位置
                                    Cursor c = adapter.getCursor();
                                    //内部类访问可变变量有问题
                                    c.moveToPosition(position);
                                    //获取数据库中这条数据的_id
                                    int itemId = c.getInt(c.getColumnIndex("_id"));
                                    //删除对应的数据,参数为表名，删除的条件，条件的结果
                                    dbWrite.delete("user","_id=?",new String[]{itemId+""});
                                    refershListview();

                                }
                            }).setNegativeButton("取消",null).show();
                    //反馈操作系统此次是否为长按，true为长按，可触发震动等
                    return true;
                }
            });


        }catch (Exception e){
            Log.e("create",e.getMessage());
        }
    }

    //更改adapter的Cursor,从而达到更新列表项
    private void refershListview(){
        Cursor c = dbRead.query("user",null,null,null,null,null,null);
        adapter.changeCursor(c);
    }
}

