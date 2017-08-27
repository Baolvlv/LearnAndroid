package com.example.bwx.viewpagedemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by bwx on 2017/2/9.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private List<View> views;
    private Context context;

    public ViewPagerAdapter(List<View> views,Context contex){
        this.views = views;
        this.context = contex;


    }

    //当view销毁时移除
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    //添加view
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
         container.addView(views.get(position));
         return views.get(position);
    }

    //返回当前view的数量
    @Override
    public int getCount() {
        return views.size();
    }

    //判断当前的view是不是需要的对象
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
