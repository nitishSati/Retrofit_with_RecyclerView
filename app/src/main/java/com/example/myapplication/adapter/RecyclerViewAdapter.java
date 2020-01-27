package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activity.DetailsActivity;
import com.example.myapplication.activity.MainActivity;
import com.example.myapplication.model.CountryList;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<CountryList> countryList;
    private OnItemClickListener listener;
    private Context context;

    public interface OnItemClickListener{
        void click(int position);
    }

    public RecyclerViewAdapter(ArrayList<CountryList> countryList, OnItemClickListener listener,Context context) {
        this.countryList = countryList;
        this.listener=listener;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.country_name,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, final int position) {
//        holder.id.setText(String.valueOf(countryList.get(position).getId()));
//        holder.sortname.setText(countryList.get(position).getSortname());
        holder.name.setText(countryList.get(position).getName());
//        holder.phonecode.setText(String.valueOf(countryList.get(position).getPhoneCode()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailsActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("countryData", countryList);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id,sortname,name,phonecode;

        public MyViewHolder(View view) {
            super(view);
//            id=view.findViewById(R.id.textview1);
//            sortname=view.findViewById(R.id.textview2);
            name=view.findViewById(R.id.country);
//            phonecode=view.findViewById(R.id.textview4);
        }
    }
}