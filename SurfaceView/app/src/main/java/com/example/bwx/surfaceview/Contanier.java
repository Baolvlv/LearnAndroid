package com.example.bwx.surfaceview;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by bwx on 2017/3/6.
 */

public class Contanier {

    //储存子容器的List
    private List<Contanier> children = null;

    //设置坐标
    private float x = 0, y = 0;

    //构造函数，实例化list
    public Contanier(){
        children = new ArrayList<Contanier>();
    }


    //将画布传递给子容器，同时为容器内list中所有的子容器设置画布
    public void setCanvas(Canvas canvas){

        //通过save和restore进行移动变化
        canvas.save();
        //根据当前的x,y坐标移动画布
        canvas.translate(getX(),getY());
        childernViewCanvasAndDraw(canvas);
        for(Contanier c : children){
            c.setCanvas(canvas);
        }

        canvas.restore();

    }

    //向子容器传递画布并且子容器完成自己的绘制
    public void childernViewCanvasAndDraw(Canvas canvas){

    }

    //添加子view方法
    public void addChildernView(Contanier child){
        children.add(child);
    }

    //移除子view方法
    public void removeChidernView(Contanier child){
        children.remove(child);
    }


    //get和set方法

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }
}
