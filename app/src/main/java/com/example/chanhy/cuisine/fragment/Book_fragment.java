package com.example.chanhy.cuisine.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chanhy.cuisine.Interface.BookApi;
import com.example.chanhy.cuisine.Interface.Constant;
import com.example.chanhy.cuisine.Model.BookItem;
import com.example.chanhy.cuisine.R;
import com.example.chanhy.cuisine.Rest.BookList;
import com.example.chanhy.cuisine.adapter.BookAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chanhy on 31/05/2016.
 */
public class Book_fragment extends Fragment  {

    private RecyclerView mRecyclerView;
    private ArrayList<BookItem> data;
    private BookAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_book, container, false);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.card_recycler_view);

        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        swipeRefresh();
        loadJSON();

        return view;
    }

    private void swipeRefresh() {

        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimaryDark),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimaryDark));

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               loadJSON();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void loadJSON(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BookApi request = retrofit.create(BookApi.class);

        Call<BookList> call = request.getJSON();
        call.enqueue(new Callback<BookList>() {

            @Override
            public void onResponse(Call<BookList> call, Response<BookList> response) {

                BookList jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));

                mAdapter = new BookAdapter(data);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<BookList> call, Throwable t) {
            }
        });
    }
}
