package com.example.testsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bwx on 2017/3/20.
 */

public class Db extends SQLiteOpenHelper {
    public Db(Context context) {
        super(context, "db", null, 1);
    }

    //当应用中不存在数据库时创建
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表，包含name,sex两列，文本类型，默认值为空  PRIMARY KEY AUTOINCREMENT主键自增
        db.execSQL("CREATE TABLE user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "name TEXT DEFAULT \"\"," +
                "sex TEXT DEFAULT \"\")");
    }

    //数据库升级，sql语句操作数据库，检查操作系统中的同名数据库版本号低则升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
