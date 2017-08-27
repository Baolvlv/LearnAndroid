package com.example.bwx.learnlayout;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class FrameLayoutAty extends AppCompatActivity {
    private FrameLayout root;
    private ImageView ivA;
    private ImageView ivB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_aty);
         root = (FrameLayout) findViewById(R.id.root);
         ivA = (ImageView) findViewById(R.id.ivA);
         ivB = (ImageView) findViewById(R.id.ivB);

        showA();

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ivA.getVisibility() == View.VISIBLE)
                {
                    showB();
                }
                else
                {
                    showA();
                }
            }
        });

    }
    private void showA()
    {
        ivA.setVisibility(View.VISIBLE);
        ivB.setVisibility(View.INVISIBLE);
    }
    private void showB()
    {
        ivA.setVisibility(View.INVISIBLE);
        ivB.setVisibility(View.VISIBLE);
    }
}
