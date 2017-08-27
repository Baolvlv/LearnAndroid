package com.example.bwx.drawerlayoutusing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bwx on 2017/2/13.
 */

public class ContentFragment extends Fragment{
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content,container,false);
        textView = (TextView) view.findViewById(R.id.text);
        //获得参数，设置为textView的text的值
        String text = getArguments().getString("text");
        textView.setText(text);
        return view;
    }
}
