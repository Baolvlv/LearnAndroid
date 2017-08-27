package com.example.l03translateanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

public class MainActivity extends AppCompatActivity {

    private TranslateAnimation ta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //相对于当前自身位置移动一个增量
        ta = new TranslateAnimation(0,200,0,200);
        ta.setDuration(1000);

        findViewById(R.id.btnTranslateMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(ta);
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.ta));
            }
        });
    }
}
