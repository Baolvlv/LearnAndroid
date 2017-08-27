package com.example.bwx.surfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by bwx on 2017/3/6.
 */

public class Circle extends Contanier {
    private Paint paint = null;

    public Circle(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }


    @Override
    public void childernViewCanvasAndDraw(Canvas canvas) {
        super.childernViewCanvasAndDraw(canvas);
        canvas.drawCircle(50,50,50,paint);
    }
}
