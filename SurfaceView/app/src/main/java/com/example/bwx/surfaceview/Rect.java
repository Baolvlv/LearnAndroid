package com.example.bwx.surfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by bwx on 2017/3/6.
 */

public class Rect extends Contanier{

    private Paint paint = null;

   //构造函数初始化画笔
    public Rect(){
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    public void childernViewCanvasAndDraw(Canvas canvas){
        super.childernViewCanvasAndDraw(canvas);
        canvas.drawRect(0,0,100,100,paint);
        //不断增加画布移动坐标
        this.setY(getY() +1 );


    }
}
