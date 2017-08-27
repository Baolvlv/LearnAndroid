package com.example.bwx.layoutanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

/**
 * Created by bwx on 2017/2/7.
 */

public class ExampleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.fragment_main,container,false);


        ScaleAnimation sa = new ScaleAnimation(0,1,0,1);
        sa.setDuration(5000);

        //第二个参数为延时，第二个组件在第一个动画一半的时开始
        LayoutAnimationController lac = new LayoutAnimationController(sa,0.5f);
        //设置动画顺序，从上往下，从下往上，随机
        lac.setOrder(LayoutAnimationController.ORDER_RANDOM);

        rootView.setLayoutAnimation(lac);

        return rootView;
    }
}
