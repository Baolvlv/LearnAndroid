package com.example.l02layoutchangeanim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout rootView;
    private View.OnClickListener btn_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rootView.removeView(v);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = (LinearLayout) findViewById(R.id.rootView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                    return true;
            case R.id.action_add:
                addButton();
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void addButton(){
        Button btn = new Button(this);
        btn.setText("Remove me");
        rootView.addView(btn);


        btn.setOnClickListener(btn_onClickListener);



        //自定义布局内容改变动画
        //rootView.setLayoutTransition(transition);
    }
}
