package com.example.chanhy.cuisine.Interface;

import com.example.chanhy.cuisine.Rest.CaseList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chanhy on 20/06/2016.
 */
public interface CaseApi  {

    @GET("api/Products")
    Call<CaseList> getCaseData();
}
