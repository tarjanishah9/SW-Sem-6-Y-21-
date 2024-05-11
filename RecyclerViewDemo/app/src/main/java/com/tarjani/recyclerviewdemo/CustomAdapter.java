package com.tarjani.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    Context context;
    String country[];
    int flag[];

    public CustomAdapter(Context context, String[] country, int[] flag) {
        this.context = context;
        this.country = country;
        this.flag = flag;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_row,null);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     //   holder.textCountry.setText(country[position]);
        holder.imgFlag.setImageResource(flag[position]);

    }

    @Override
    public int getItemCount() {
        return country.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textCountry;
        ImageView imgFlag;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
       //     textCountry=itemView.findViewById(R.id.txtCountry);
            imgFlag=itemView.findViewById(R.id.imgFlag);

        }
    }
}
