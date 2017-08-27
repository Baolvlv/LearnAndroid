package com.example.bwx.usingcontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by bwx on 2017/3/21.
 */

public class UsersCp extends ContentProvider {

    private UsersDb usersDb;
    private SQLiteDatabase dbWrite,dbRead;
    public static final String TABLE_NAME ="user";
    //ContentProvider的Uri必须以content://开头
    public static final Uri URI =Uri.parse("content://com.example.bwx.usingcontentprovider.UsersCp");


    @Override
    public boolean onCreate() {

        usersDb = new UsersDb(getContext());
        dbRead = usersDb.getReadableDatabase();
        dbWrite = usersDb.getWritableDatabase();

        //创建成功返回true
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
       //第二个参数为查询的列
        return dbRead.query(TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        dbWrite.insert(TABLE_NAME,null,values);
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return dbWrite.delete(TABLE_NAME,selection,selectionArgs);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return dbWrite.update(TABLE_NAME,values,selection,selectionArgs);
    }
}
