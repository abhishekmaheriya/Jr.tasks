package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final ArrayList<Student> listdata;
//    private final Context context;
    private static final String TAG = "Adapter" ;
    ItemClickListener itemClickListener;

    public Adapter(ArrayList<Student> listdata, ItemClickListener itemClickListener) {
        this.listdata = listdata;
        this.itemClickListener = itemClickListener;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
      holder.intGl.setText((position+1)+"");
      holder.name.setText(listdata.get(position).name +"");

        if (listdata.get(position).isSelected) {
            holder.layout.setBackgroundColor(Color.parseColor("#FF03DAC5"));
//            notifyDataSetChanged();
        }else {
            holder.layout.setBackgroundColor(Color.parseColor("#ffffff"));
//            notifyDataSetChanged();
        }

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView intGl, name, isSelected;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            intGl = itemView.findViewById(R.id.tv1);
            name = itemView.findViewById(R.id.tv2);
            isSelected = itemView.findViewById(R.id.tv3);
            layout = itemView.findViewById(R.id.l1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
     }
    }
