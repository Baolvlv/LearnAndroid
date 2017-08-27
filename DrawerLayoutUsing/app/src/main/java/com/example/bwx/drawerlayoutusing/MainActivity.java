package com.example.bwx.drawerlayoutusing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private DrawerLayout mDrawerLayout;
    private ListView mDrawList;
    private ArrayList<String> menuLists;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawList = (ListView) findViewById(R.id.left_drawer);
        menuLists = new ArrayList<>();
        for(int i = 0;i<5;i++){
            menuLists.add("baolvlv"+i);
        }
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,menuLists);
        mDrawList.setAdapter(adapter);

        mDrawList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //动态插入一个fragment到FrameLayout当中
        Fragment contentFragment = new ContentFragment();
        //将点选的item作为参数，通过Bundle传递给fragment
        Bundle args = new Bundle();
        args.putString("text",menuLists.get(position));
        contentFragment.setArguments(args);

        //替换当前fragment为新的fragment
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame,contentFragment).commit();

        //点选之后关闭左侧的抽屉
        mDrawerLayout.closeDrawer(mDrawList);

    }
}
