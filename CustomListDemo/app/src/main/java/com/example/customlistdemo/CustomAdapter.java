package com.example.customlistdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    int[] imgArr;
    String[] strMain;
    String[] strSub;
    MainActivity activity;

    public CustomAdapter(MainActivity activity,int[] imgArr, String[] strMain, String[] strSub) {
        this.activity=activity;
        this.imgArr = imgArr;
        this.strMain = strMain;
        this.strSub = strSub;
    }

    @Override
    public int getCount() {
        return imgArr.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v= LayoutInflater.from(activity).inflate(R.layout.list_row,null);
        ImageView imgData=v.findViewById(R.id.imgData);
        TextView txtMain=v.findViewById(R.id.txtMain);
        TextView txtSub=v.findViewById(R.id.txtSub);
        imgData.setImageResource(imgArr[i]);
        txtMain.setText(strMain[i]);
        txtSub.setText(strSub[i]);
        return v;
    }
}
