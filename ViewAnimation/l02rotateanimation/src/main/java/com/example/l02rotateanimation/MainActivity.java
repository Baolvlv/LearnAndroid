package com.example.l02rotateanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;

public class MainActivity extends AppCompatActivity {

    private RotateAnimation ra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ra = new RotateAnimation(0,360,100,50);//后两个参数为中心点的像素

        //设置相对于控件自身中心点（比例 0.5f）
        ra = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        //设置动画时间为1秒
        ra.setDuration(1000);

        findViewById(R.id.btnRotateMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(ra);
                v.startAnimation(AnimationUtils.loadAnimation(getApplication(),R.anim.ra));
            }
        });
    }
}
