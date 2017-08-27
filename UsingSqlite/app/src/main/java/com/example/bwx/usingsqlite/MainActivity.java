package com.example.bwx.usingsqlite;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.os.Bundle;

public class MainActivity extends ListActivity {

    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Db db = new Db(this);
        SQLiteDatabase dbRead = db.getReadableDatabase();
        Cursor c = dbRead.query("user",null,null,null,null,null,null);

        //参数：context,布局资源，Cursor,Cursor的需要输出的数据源，输出的位置
        //SimpleCursorAdapter要求数据表中必须有_id这一列
        adapter = new SimpleCursorAdapter(this,R.layout.user_list_cell
                ,c,new String[]{"name","sex"},new int[]{R.id.tvName,R.id.tvsex});
        setListAdapter(adapter);





//        //实例化数据库对象
//        Db db = new Db(this);
//        //获取可写入数据库用于插入数据
//        SQLiteDatabase dbWrite = db.getWritableDatabase();
//        //使用ContentValues封装数据
//        ContentValues cv = new ContentValues();
//        //输入对应的键值对的值
//        cv.put("name","bss");
//        cv.put("sex","男");
//        //插入数据，参数为表名，当列为空时的填充值，封装数据的ContentValue
//        dbWrite.insert("user",null,cv);
//
//        ContentValues cv2 = new ContentValues();
//        cv2.put("name","watermelon");
//        cv2.put("sex","女");
//        dbWrite.insert("user",null,cv2);
//        //使用完之后关闭数据库
//        dbWrite.close();

        //new String[]{"name"} "name = \"bss\""  "name =?",new String[]{"bss"
        // ／／SQLiteDatabase dbRead = db.getReadableDatabase();
        //参数：表名，查询的列，查询条件，条件参数，分组,分组条件，顺序
//        Cursor c = dbRead.query("user",null,null,null,null,null,null);
//
//        while (c.moveToNext()){
//            String name = c.getString(c.getColumnIndex("name"));
//            String sex = c.getString(c.getColumnIndex("sex"));
//            System.out.println(String.format("name=%s,sex=%s",name,sex));

//        }
    }
}
