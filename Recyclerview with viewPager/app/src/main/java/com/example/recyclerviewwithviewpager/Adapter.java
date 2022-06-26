package com.example.recyclerviewwithviewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    RecyclerViewItemClick recyclerViewItemClick;
    ArrayList<Model> list;

    public Adapter(RecyclerViewItemClick recyclerViewItemClick, ArrayList<Model> list) {
        this.recyclerViewItemClick = recyclerViewItemClick;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ivPicture.setImageResource(list.get(position).img);
        holder.txtTitle.setText(list.get(position).title);
        holder.txtSubtitle.setText(list.get(position).subTitle);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPicture;
        TextView txtTitle, txtSubtitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPicture = itemView.findViewById(R.id.imagePicture);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtSubtitle = itemView.findViewById(R.id.txtSubTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewItemClick.onClick(getAdapterPosition());
                }
            });
        }
    }
}
