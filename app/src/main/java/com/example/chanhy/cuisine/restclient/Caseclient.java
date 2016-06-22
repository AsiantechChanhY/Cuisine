package com.example.chanhy.cuisine.restclient;

import com.example.chanhy.cuisine.Interface.CaseApi;
import com.example.chanhy.cuisine.Interface.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chanhy on 21/06/2016.
 */
public class Caseclient  {

    private static Retrofit getRetrofitCase(){
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Constant.CASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static CaseApi getApiCase(){
        CaseApi caseApi = getRetrofitCase().create(CaseApi.class);
        return caseApi;
    }
}
