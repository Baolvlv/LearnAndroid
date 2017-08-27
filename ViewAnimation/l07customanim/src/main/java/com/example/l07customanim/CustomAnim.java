package com.example.l07customanim;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by bwx on 2017/2/6.
 */

public class CustomAnim extends Animation {

    //获取目标容器于父级容器的宽高
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        //在动画开始时，initialize方法先执行，获取到目标对象的宽高
        //System.out.println("init");
    }

    //设置变化形态
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {


        //参数interpolatedTime为补间时间，动画开始时为0，结束时为1，动画过程中从0到1变化
        //参数Transformation可以设置变化的形态, 如设置透明
        //t.setAlpha(interpolatedTime);

        //设置其他的变化getMatrix
        // 用最终位置乘interpolatedTime,进行到最终位置的缓慢移位
       // t.getMatrix().setTranslate(200*interpolatedTime,200*interpolatedTime);

        //以10为振幅的左右周期震动
        t.getMatrix().setTranslate((float) (Math.sin(interpolatedTime*10)*10),0);
        super.applyTransformation(interpolatedTime, t);
    }
}
