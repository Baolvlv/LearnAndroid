package com.example.bwx.learnrv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bwx on 2016/12/1.
 */
class MyAdapter extends RecyclerView.Adapter {
    //自创viewholder类
    class ViewHolder extends RecyclerView.ViewHolder {
        //绑定子对象视图
        private View root;
        private TextView tvTitle;
        private TextView tvContect;

        public ViewHolder(View root) {
            super(root);

            tvTitle = (TextView) root.findViewById(R.id.tvTitle);
            tvContect = (TextView) root.findViewById(R.id.tvContent);

        }


        public TextView getTvTitle() {
            return tvTitle;
        }

        public TextView getTvContect() {
            return tvContect;
        }
    }

    @Override
    //创建viewholder的方法
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建布局
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell,null));
    }

    @Override
    //对textView进行赋值
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;

        CellData cd = data[position];

        vh.getTvTitle().setText(cd.title);
        vh.getTvContect().setText(cd.content);

    }

    @Override
    //获取rv子对象的数量
    public int getItemCount() {
        return data.length;
    }


    private CellData[] data = new CellData[]{new CellData("hello","bss"),new CellData("today","sad"),new CellData("hello","bss"),new CellData("hello","bss"),new CellData("hello","bss"),new CellData("hello","bss"),new CellData("hello","bss"),new CellData("hello","bss"),new CellData("hello","bss"),new CellData("hello","bss"),new CellData("hello","bss"),new CellData("hello","bss"),new CellData("hello","bss")};
    //使用数组存放与读取数据
//    private String[] data = new String[]{"hello", "bss", "sad"};
}
