package com.example.l05anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //AnimationSet可储存多个动画
    //private AnimationSet as;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //是否共用动画补间：true；动画补间：动画是加速还是匀速执行
//        as = new AnimationSet(true);
//        as.setDuration(1000);
//
//        AlphaAnimation aa = new AlphaAnimation(0,1);
//        aa.setDuration(1000);
//        as.addAnimation(aa);
//
//        TranslateAnimation ta = new TranslateAnimation(200,0,200,0);
//        ta.setDuration(1000);
//        as.addAnimation(ta);

        findViewById(R.id.btnAnimMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.startAnimation(as);
                Animation a = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim);

                a.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this,"Animation end",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                v.startAnimation(a);
            }
        });
    }


}
