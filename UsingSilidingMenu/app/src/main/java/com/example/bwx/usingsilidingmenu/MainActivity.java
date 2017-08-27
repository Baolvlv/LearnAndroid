package com.example.bwx.usingsilidingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {
    private SlidingMenu slidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidingMenu = new SlidingMenu(this);//创建对象
        slidingMenu.setMode(SlidingMenu.LEFT);//设置模式，slidingMenu位于左侧
        slidingMenu.setBehindOffsetRes(R.dimen.sliding_menu_offset);//设置拖动后呈现的尺寸
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//设置触摸模式，全屏可触摸
        slidingMenu.setMenu(R.layout.slidingmenu);
        slidingMenu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);//附加到当前activity上
    }




    //返回键关闭slidingMenu
//    @Override
//    public void onBackPressed() {
//        if(slidingMenu.isMenuShowing())
//        {
//            slidingMenu.showContent();
//        }
//        else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if(slidingMenu.isMenuShowing())
                    slidingMenu.showContent();//返回键关闭SlidingMenu
                else finish();
                return true;
            case KeyEvent.KEYCODE_MENU:
                slidingMenu.toggle();
                return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
