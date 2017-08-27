package com.example.l04scaleanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;

public class MainActivity extends AppCompatActivity {

    private ScaleAnimation sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //相对于控件自身的（100，50）像素位置，从原大小放大至两倍
        sa = new ScaleAnimation(1,2,1,2,100,50);
        //相对于自身位置中心点从0放大到1
        sa = new ScaleAnimation(0,1,0,1, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        sa.setDuration(1000);

        findViewById(R.id.btnScaleMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(sa);
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.sa));
            }
        });
    }
}
