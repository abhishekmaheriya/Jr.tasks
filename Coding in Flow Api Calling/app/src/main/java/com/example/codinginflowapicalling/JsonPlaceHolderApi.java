package com.example.codinginflowapicalling;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts(
//            @Query("userId") int userId,     // it's fetch data according to the user id
            @Query("userId") Integer [] userId,     // it's fetch data according to the user id
            @Query("_sort") String sort,
            @Query(("_order")) String order   //  these two are sort the id in descending order
    );

    Call<List<Post>> getPosts(@QueryMap Map<String,String> parameters);


    // for decreasing order our api will look like
    // http://jsonplaceholder.typicode.com/comments?postId=1&_sort=id&_order=desc

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);
}
