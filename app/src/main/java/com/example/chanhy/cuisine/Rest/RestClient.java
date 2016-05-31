package com.example.chanhy.cuisine.Rest;

import com.example.chanhy.cuisine.Interface.ApiService;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chanhy on 23/05/2016.
 */
public class RestClient {

    private static ApiService apiService;
    private static String BASE_URL  = "http://localhost:3000/api/";

    private RestClient() {}

    public static ApiService getClient(){
        if(apiService == null) {

            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());

                    Request oriRequest = chain.request();

                    Request request  = oriRequest.newBuilder()
                            .header("Content-Type", "application/json")
                            .method(oriRequest.method(), oriRequest.body())
                            .build();

                    return chain.proceed(request);
                }
            });

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }
}
