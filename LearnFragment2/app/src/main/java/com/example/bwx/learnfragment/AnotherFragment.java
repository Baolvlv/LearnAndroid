package com.example.bwx.learnfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bwx on 2017/1/22.
 */

public class AnotherFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        System.out.println("onCreat");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       System.out.println("onCreateView");

        View root = inflater.inflate(R.layout.fragment_another,container,false);
        root.findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();//支持程序中的后退键
            }
        });
        return root;
    }

    @Override
    public void onPause() {

        System.out.println("onPause");
        super.onPause();
    }

    @Override
    public void onDestroy() {
        System.out.println("onDestroy");
        super.onDestroy();
    }
}
