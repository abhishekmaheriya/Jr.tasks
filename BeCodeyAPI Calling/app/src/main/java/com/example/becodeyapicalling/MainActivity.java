package com.example.becodeyapicalling;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                APISet apiSet = RetrofitClient.getRetrofitInstance().create(APISet.class);
                Call<ArrayList<ApiModel>> call = apiSet.getdata();
               call.enqueue(new Callback<ArrayList<ApiModel>>() {
                   @Override
                   public void onResponse(Call<ArrayList<ApiModel>> call, Response<ArrayList<ApiModel>> response) {
                       response.body();
                       Log.d(TAG, "onResponse: "+response.body());
                   }

                   @Override
                   public void onFailure(Call<ArrayList<ApiModel>> call, Throwable t) {
//                       Snackbar.make(recyclerView, "Something went wrong ", Snackbar.LENGTH_LONG).show();
                       Toast.makeText(MainActivity.this, "Something went wrong ", Toast.LENGTH_SHORT).show();
                   }
               });

    }
}