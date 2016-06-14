package com.example.chanhy.cuisine.Interface;

import com.example.chanhy.cuisine.Rest.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chanhy on 19/05/2016.
 */
public interface ApiService {

    @GET("api/Products")
    Call<JSONResponse> getJSON();
}
