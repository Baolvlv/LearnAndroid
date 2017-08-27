package com.example.bwx.multouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout root;
    private ImageView iv;
    //两个触控点之间当前的距离
    private float currentDistance;
    //两个触控点之间上一次操作后的距离
    private float lastDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = (RelativeLayout) findViewById(R.id.activity_main);
        iv = (ImageView) findViewById(R.id.iv);

        //侦听触摸事件，onTouchListener
        root.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //根据event.getAction判断触摸类型
                switch (event.getAction()){
                    //触摸按下事件
                    case MotionEvent.ACTION_DOWN:
                       System.out.println("action down");
                        break;
                    //触摸移动事件
                    case MotionEvent.ACTION_MOVE:
                        //越向右下方移动，x坐标与y坐标越大
                        //System.out.println(String.format("x:%f,y:%f",event.getX(),event.getY()));

//                        //创建iv的布局参数对象
//                        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) iv.getLayoutParams();
//                        //设置子视图在根布局中的左侧空白，为当前触摸位置
//                        lp.leftMargin = (int) event.getX();
//                        //设置子视图在根布局中的上部空白，为当前触摸位置
//                        lp.topMargin = (int) event.getY();
//                        //设置imageView的布局参数
//                        iv.setLayoutParams(lp);



                        if(event.getPointerCount()>=2){
                            //两触控点之间的x偏移量和y偏移量
                            float offsetX = event.getX(0)-event.getY(1);
                            float offsetY = event.getY(0)-event.getY(1);
                            //计算两点之间的距离
                            currentDistance = (float) Math.sqrt(offsetX*offsetX+offsetY*offsetY);

                            //避免实际操作中，距离计算的误差，使用两次距离差大于或小于5作为判断依据
                            if(currentDistance - lastDistance >5){
                                System.out.println("放大");
                                //设置imageView布局参数
                                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) iv.getLayoutParams();

                               //放大时宽度与高度需要使用getHeight与getWidth获取到当前真实的高度与宽度
                                //需要使用明确浮点数进行乘法
                                lp.width = (int) (1.1f*iv.getWidth());
                                lp.height = (int) (1.1f*iv.getHeight());
                                iv.setLayoutParams(lp);
                                //更新lastDistence的值
                                lastDistance = currentDistance;
                            }else if (lastDistance - currentDistance >5){
                                System.out.println("缩小");

                                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) iv.getLayoutParams();
                                lp.height = (int) (0.9f*iv.getHeight());
                                lp.width = (int) (0.9f *iv.getWidth());
                                iv.setLayoutParams(lp);

                                lastDistance = currentDistance;
                            }
                        }





//
//                        //获取触摸点的个数
//                        System.out.println("point count: "+event.getPointerCount());
//                        //获取多个触摸点位置
//                        System.out.println(String.format
//                                ("x1:%f,y1:%f x2:%f,y2:%f",event.getX(0),event.getY(0),event.getX(1),event.getY(1)));
//                        break;
                    //触摸弹起事件
                    case MotionEvent.ACTION_UP:
                        System.out.println("action up");
                        break;

                }
                return true;
            }
        });
    }
}
