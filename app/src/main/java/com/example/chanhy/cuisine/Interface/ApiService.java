package com.example.chanhy.cuisine.Interface;

import com.example.chanhy.cuisine.Model.LoginPojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by chanhy on 19/05/2016.
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("/Users/login")
    Call<LoginPojo> login(@Field("email") String email,
                          @Field("username") String username);

}
