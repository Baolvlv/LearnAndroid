package com.example.bwx.viewanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAnimMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置透明动画，透明度0-1
                AlphaAnimation aa = new AlphaAnimation(0,1);
                //设置动画的时间长度
                aa.setDuration(1000);
                v.startAnimation(aa);


                v.startAnimation(AnimationUtils.loadAnimation(getApplication(),R.anim.aa));

            }
        });
    }
}
