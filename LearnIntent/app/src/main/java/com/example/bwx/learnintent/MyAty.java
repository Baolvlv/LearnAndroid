package com.example.bwx.learnintent;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by bwx on 2016/9/28.
 */
public class MyAty extends Activity {

    public static final String ACTION ="com.example.bwx.learnintent.intent.action.MyAty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定Activity与视图文件
        setContentView(R.layout.myaty);
    }
}
