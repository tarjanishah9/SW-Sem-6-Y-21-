package com.example.customlistdemo;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    ArrayList<Integer> imgArr;
    ArrayList<String> mainArr;
    ArrayList<String> subArr;
    MainActivity activity;

    public CustomAdapter(MainActivity activity,ArrayList<Integer> imgArr, ArrayList<String> mainArr, ArrayList<String> subArr) {
        this.imgArr = imgArr;
        this.mainArr = mainArr;
        this.subArr = subArr;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return imgArr.size();
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
        View v;
        if(i%2==0) {

            v = LayoutInflater.from(activity).inflate(R.layout.list_row, null);
        }
        else
        {
            v=LayoutInflater.from(activity).inflate(R.layout.list_row_right,null);
        }
        ImageView imgData=v.findViewById(R.id.imgData);
        TextView txtMain=v.findViewById(R.id.txtMain);
        TextView txtSub=v.findViewById(R.id.txtSub);
        imgData.setImageResource(imgArr.get(i));
        txtMain.setText(mainArr.get(i));
        txtSub.setText(subArr.get(i));

        imgData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(activity);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_layout);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//             /   dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCancelable(false);
                ImageView imgData=dialog.findViewById(R.id.imgData);
                TextView txtName=dialog.findViewById(R.id.txtName);
                imgData.setImageResource(imgArr.get(i));
                txtName.setText(mainArr.get(i));
                dialog.show();
            }
        });

        return v;
    }
}
