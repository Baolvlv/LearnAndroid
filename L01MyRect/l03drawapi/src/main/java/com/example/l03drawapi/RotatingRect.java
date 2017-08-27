package com.example.l03drawapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bwx on 2017/1/29.
 */

public class RotatingRect extends View {

    public RotatingRect(Context context) {
        super(context);

        initProperties();
    }

    public RotatingRect(Context context, AttributeSet attrs) {
        super(context, attrs);

        initProperties();
    }

    public RotatingRect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initProperties();
    }

    //初始化属性
    private void initProperties(){
        paint = new Paint();
        paint.setColor(0xffff0000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
       // canvas.rotate(degrees);默认左上角旋转
        //移动位置
        canvas.translate(200,200);
        canvas.rotate(degrees,50,50);
        canvas.drawRect(0,0,100,100,paint);

        degrees++;
        canvas.restore();

        //使view无效，不断执行draw方法
        invalidate();
    }
    //定义画笔对象
    private Paint paint;
    private float degrees = 0;
}
