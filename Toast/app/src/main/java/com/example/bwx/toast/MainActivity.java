package com.example.bwx.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button showToastShort;
    private Button showToastLong;
    private Button showImageToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToastShort = (Button) findViewById(R.id.btnShowToast);
        showToastShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //先makeText，后show进行显示，makeText三个参数为context,显示的文本，显示的时长
               Toast aShortToast = Toast.makeText(MainActivity.this,"显示一个简短的Toast",Toast.LENGTH_SHORT);
                //后两个参数为x轴和y轴的偏移量，x轴正值向右偏移，y轴正值为向下偏移
                aShortToast.setGravity(Gravity.CENTER,100,-200);
                aShortToast.show();

            }
        });

        showToastLong = (Button) findViewById(R.id.btnShowToastLong);
        showToastLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"显示一个较长的Toast",Toast.LENGTH_LONG).show();
            }
        });


        showImageToast = (Button) findViewById(R.id.btnShowImageToast);
        showImageToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast imageToast = Toast.makeText(MainActivity.this,"这是一个带有图片的toast",Toast.LENGTH_LONG);
                //创建imageView，并设置图片源
                ImageView iv = new ImageView(MainActivity.this);
                iv.setImageResource(R.mipmap.ic_launcher);
                //为Toast设置view
                imageToast.setView(iv);




                //图片作为view显示在Toast中，将取代之前设置的文本，如果想要设置多种内容
                //需要自定义layout，将layout传给setView方法

            }
        });
    }
}
