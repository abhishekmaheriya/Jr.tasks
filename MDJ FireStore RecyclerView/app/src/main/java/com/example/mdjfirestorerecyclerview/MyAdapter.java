package com.example.mdjfirestorerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder > {
    Context context;
    ArrayList<model> datalist;

    public MyAdapter(ArrayList<model> datalist) {
        this.datalist = datalist;
    }

    public MyAdapter(Context context, ArrayList<model> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.txtname.setText(datalist.get(position).getName());
        holder.txtemail.setText(datalist.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname, txtemail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtname);
            txtemail = itemView.findViewById(R.id.txtemail);
        }
    }
}
