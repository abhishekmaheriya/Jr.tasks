package com.example.taskfakeapiretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerItemClick {
    RecyclerView recview;
    MyAdapter adapter;
    List<Model> data;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recview = findViewById(R.id.recyclerView);
        recview.setLayoutManager(new LinearLayoutManager(this));
        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching Details Of products");
        dialog.show();

        processData();
    }

    public void processData() {
        Call<List<Model>> call = ApiController
                .getInstance()   // get instance from the ApiController
                .getapi()       // get list of api from the ApiController
                .getposts();    // Call the method which get the web api data

        call.enqueue(new Callback<List<Model>>() {  // get the data sequentially
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                 data = response.body();
                 dialog.dismiss();
//                adapter = new MyAdapter(data);
                adapter = new MyAdapter(data , MainActivity.this::onClick); // required reference of recyclerItemClick so use mainactivity.this::onClick
//                setAdapterListner();
                recview.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Snackbar.make(recview, "Something went wrong ", Snackbar.LENGTH_LONG).show();
                dialog.dismiss();
//                finish();
            }
        });
    }

//    private void setAdapterListner() {
//        adapter.setAdapterLstnr(this);
//    }

    @Override
    public void onClick(int position) {
//        Snackbar.make(recview, "You select " + position, Snackbar.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(),SubDataActivity.class);
//        intent.putExtra("data",  (Model) data.get(position));
        ArrayList<Model> arrayList = new ArrayList<>();
        arrayList.addAll(data);
        intent.putExtra("ModelData", arrayList);
        intent.putExtra("position",position);
        startActivity(intent);

    }
}