package com.example.bwx.learnfragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by bwx on 2017/1/23.
 */

public class WebViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.web_view_fragmnet,container,false);
        WebView wv = (WebView) root.findViewById(R.id.wv);
        wv.loadUrl("https://www.baidu.com ");
        return root;
    }
}
