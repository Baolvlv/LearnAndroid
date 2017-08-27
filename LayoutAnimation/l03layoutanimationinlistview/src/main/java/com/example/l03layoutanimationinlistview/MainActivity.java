package com.example.l03layoutanimationinlistview;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    private ArrayAdapter<String> adapter;
//    private LayoutAnimationController lac;
//    private ScaleAnimation sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new String[]{"kk","bss","welcome"});

        setListAdapter(adapter);

        setContentView(R.layout.main);

//        sa = new ScaleAnimation(0,1,0,1);
//        sa.setDuration(1000);
//
//        lac = new LayoutAnimationController(sa,0.5f);
//
//        getListView().setLayoutAnimation(lac);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
