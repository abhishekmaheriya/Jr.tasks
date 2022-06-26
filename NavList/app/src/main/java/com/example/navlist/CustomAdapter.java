package com.example.navlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context  context;
    List<Item>items;

    public CustomAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_view_item_type2, null);
        ImageView icon = v.findViewById(R.id.icon);
        TextView text = v.findViewById(R.id.text);
        icon.setImageResource(items.get(position).getImage());
        text.setText(items.get(position).getName());
        //event handling code can be done here
        return v;
    }
}
