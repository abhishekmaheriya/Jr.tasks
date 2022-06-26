package com.example.taskfakeapiretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Callback;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myviewholder>{
    List<Model> data;
    RecyclerItemClick recyclerItemClick;


    public MyAdapter(List<Model> data, RecyclerItemClick recyclerItemClick) {
        this.data = data;
        this.recyclerItemClick = recyclerItemClick;
    }

    public void setAdapterLstnr(RecyclerItemClick recyclerItemClick)
    {
        this.recyclerItemClick = recyclerItemClick;
    }

    @NonNull
    @Override
    public MyAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.myviewholder holder, int position) {
        holder.txtId.setText(""+data.get(position).getId());
//        holder.txtCategory.setText(data.get(position).getCategory());
//        holder.txtDescription.setText(data.get(position).getDescription());
        holder.txtPrice.setText(""+data.get(position).getPrice()+"");
        holder.txtTitle.setText(data.get(position).getTitle());
        Glide.with(holder.txtId.getContext()).load(data.get(position).getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtId,txtTitle,txtPrice,txtDescription,txtCategory;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtId);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtPrice = itemView.findViewById(R.id.txtPrice);
//            txtDescription = itemView.findViewById(R.id.txtDescription);
//            txtCategory = itemView.findViewById(R.id.txtCategory);
            img = itemView.findViewById(R.id.imgApi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerItemClick.onClick(getAdapterPosition());
                }
            });
        }
    }
}
