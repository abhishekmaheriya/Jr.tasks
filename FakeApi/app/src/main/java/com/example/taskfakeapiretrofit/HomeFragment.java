package com.example.taskfakeapiretrofit;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class HomeFragment extends Fragment {
    TextView title_get,price_get,category_get,description_get,rating_get;
    ImageView img_get;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        title_get = view.findViewById(R.id.title_get);
        price_get = view.findViewById(R.id.price_get);
        category_get = view.findViewById(R.id.category_get);
        description_get = view.findViewById(R.id.description_get);
        rating_get = view.findViewById(R.id.rating_get);
        img_get = view.findViewById(R.id.img_get);



        String titleMsg =getArguments().getString("Title");
        String priceMsg =getArguments().getString("price");
        String categoryMsg =getArguments().getString("category");
        String descriptionMsg =getArguments().getString("description");
        String ratingMsg =getArguments().getString("rating");
        String images = getArguments().getString("image");

        title_get.setText(titleMsg);
        price_get.setText(priceMsg);
        category_get.setText(categoryMsg);
        description_get.setText(descriptionMsg);
        rating_get.setText(ratingMsg);
//        Uri imgUri = Uri.parse(images);
//        img_get.setImageURI(null);
//        img_get.setImageURI(imgUri);
        Glide.with(getActivity()).load(images).into(img_get);
        return view;
    }
}