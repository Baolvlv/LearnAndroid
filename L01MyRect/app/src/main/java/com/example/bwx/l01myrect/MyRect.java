package com.example.bwx.l01myrect;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bwx on 2017/1/26.
 */

public class MyRect extends View {


    //由资源解析程序使用的构造方法
    public MyRect(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.MyView);

        int color = ta.getColor(R.styleable.MyView_rect_color,0xffff0000);
        setBackgroundColor(color);

        //使用完之后回收
        ta.recycle();
    }


    //由代码使用的构造方法
    public MyRect(Context context) {
        super(context);
    }
}
