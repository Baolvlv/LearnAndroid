package com.example.bwx.viewpagedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bwx on 2017/2/9.
 */

public class Guide extends Activity implements ViewPager.OnPageChangeListener{

    private ViewPager vp;
    private ViewPagerAdapter vpAdapater;
    private List<View> views;

    //储存多个ImageView的数组
    private ImageView[] dots;
    //储存多个ImageView ID的数组
    private int[] ids = {R.id.iv1,R.id.iv2,R.id.iv3};

    private Button start_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        initViews();
        initDots();
    }

    //  初始化view
    private void initViews(){
        LayoutInflater inflater = LayoutInflater.from(this);

        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.one,null));
        views.add(inflater.inflate(R.layout.two,null));
        views.add(inflater.inflate(R.layout.three,null));

        vpAdapater = new ViewPagerAdapter(views,this);

        vp = (ViewPager) findViewById(R.id.viewpage);

        vp.setAdapter(vpAdapater);
       //先通过view获取到包含button的布局，再通过findViewById查找到当前button
        start_btn = (Button) views.get(2).findViewById(R.id.start_btn);
        //设置事件监听器
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置启动下一个activity
                Intent i = new Intent(Guide.this,MainActivity.class);
                startActivity(i);
                //结束当前activity
                finish();
            }
        });


        //添加页面改变的回调
        vp.addOnPageChangeListener(this);


    }
   //初始化点数组，通过循环对每个点查找id后赋值，初始化数组中每个点
    private void initDots(){
        dots = new ImageView[views.size()];
        for (int i = 0;i<views.size();i++){
            dots[i] = (ImageView) findViewById(ids[i]);
        }
    }

    //当页面滚动后方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //当页面选择后
    @Override
    public void onPageSelected(int position) {
        for (int i =0;i<ids.length;i++){
            if(position == i){
                dots[i].setImageResource(R.drawable.login_point_selected);
            }else{
                dots[i].setImageResource(R.drawable.login_point);
            }
        }

    }

    //当页面滚动状态改变时
    @Override
    public void onPageScrollStateChanged(int state) {


    }
}
