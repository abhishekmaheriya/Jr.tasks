package com.example.becodeyapicalling;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APISet {
    @GET("api/users?page=2")
    Call<ArrayList<ApiModel>> getdata();
}
