package com.example.bwx.learncontext;

import android.app.Application;
import android.content.res.Configuration;

/**
 * Created by bwx on 2016/9/29.
 */
public class App extends Application {

    private String textData ="default";

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public String getTextData() {
        return textData;
    }

    //app创建，只要启动应用中的Activity,Application的onCreate函数都会执行，且比Activity的onCreate函数先执行
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("App onCreate");
    }
    //app结束，一般不执行，在模拟环境下执行

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    //onLowMemory在低内存的时候执行

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
    //在内存清理的时候执行

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
    //配置发生改变时执行
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
