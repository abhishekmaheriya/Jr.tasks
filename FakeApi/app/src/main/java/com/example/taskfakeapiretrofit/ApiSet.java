package com.example.taskfakeapiretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiSet {
    // it will send GET request to api
    @GET("products")
    Call<List<Model>> getposts(); // getposts() is for to get he data from web api
}
