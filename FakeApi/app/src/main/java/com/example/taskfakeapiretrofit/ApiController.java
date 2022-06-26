package com.example.taskfakeapiretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {
    public static final String url = "https://fakestoreapi.com/";
    private static ApiController clientObject;
    private static Retrofit retrofit;

    ApiController(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                // we required to covert json to Gson and then it will convert in object
                .addConverterFactory(GsonConverterFactory.create())   // it will convert the serialize json into gson
                .build();  /// building the objects
    }


    // it will check the initialization
    // if object is already initialized it will return same object
    // otherwise it will initialized
    public static synchronized ApiController getInstance(){ // syncronizaed will control the access of multiple threads to any shared resource
        if (clientObject == null){
            clientObject = new ApiController();  // call the constructor so that object will initialized
        }
        return clientObject;
    }

    ApiSet getapi(){
        return retrofit.create(ApiSet.class); // it will listout all the api's mentioned in ApiSet
    }
}
