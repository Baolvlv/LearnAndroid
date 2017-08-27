package com.example.bwx.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by bwx on 2017/3/6.
 */

public class MyView extends SurfaceView implements SurfaceHolder.Callback{

   //声明画笔
    //private Paint paint = null;

    private Contanier contanier;
    private Rect rect;
    private Circle circle;

    public MyView(Context context) {
        super(context);
        //添加回调函数
        getHolder().addCallback(this);


        contanier = new Contanier();
        rect = new Rect();
        circle = new Circle();
        rect.addChildernView(circle);
        contanier.addChildernView(rect);


//        paint = new Paint();
//        paint.setColor(Color.RED);
    }

    public void draw(){
        //创建画布,图形开始时锁定画布，图形结束后解锁画布
        Canvas canvas = getHolder().lockCanvas();
        //设置画布颜色
        canvas.drawColor(Color.WHITE);
        //绘制长100宽100的矩形
         //canvas.drawRect(0,0,100,100,paint);

        //绘制线,save和restore配合使用，对单个图形进行变化不影响其他
        //保存当前画布图形，使画布处于可编辑的状态
//        canvas.save();
//        canvas.rotate(90,getWidth()/2,getHeight()/2);
//        canvas.drawLine(0,getHeight()/2,getWidth(),getHeight(),paint);
        //还原画布
        //canvas.restore();

        //canvas.drawLine(0,getHeight()/2+100,getWidth(),getHeight()+100,paint);

        //为所有容器统一设置画布
        contanier.setCanvas(canvas);

        getHolder().unlockCanvasAndPost(canvas);

    }



    //创建计时器与计时器任务对象
    private Timer timer = null;
    private TimerTask task = null;

    //开始计时器方法
    public void startTimer(){
        timer = new Timer();
        task = new TimerTask() {
            //实例化timertask，复写run方法
            @Override
            public void run() {
                draw();
            }
        };

        //timer执行timerTask,100毫秒后开始，每100毫秒执行一次
        timer.schedule(task,100,100);

    }

    //停止计时器
    public void stopTimer(){
        //当计时器不为空时，取消计时器，并设置为空
        if(timer != null){
            timer.cancel();
            timer = null;
        }

    }

    //surface创建时执行
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startTimer();
    }

    //surface改变时执行
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }


    //surface意外销毁时执行
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //surface结束之后不停止timer,会出现异常
        stopTimer();
    }
}
