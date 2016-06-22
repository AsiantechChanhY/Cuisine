package com.example.chanhy.cuisine.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.chanhy.cuisine.Interface.CaseApi;
import com.example.chanhy.cuisine.Model.CaseItem;
import com.example.chanhy.cuisine.R;
import com.example.chanhy.cuisine.Rest.BookList;
import com.example.chanhy.cuisine.Rest.CaseList;
import com.example.chanhy.cuisine.adapter.CaseAdapter;
import com.example.chanhy.cuisine.restclient.Caseclient;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chanhy on 31/05/2016.
 */
public class Case_fragment extends Fragment {

    private View parentView;
    private ArrayList<CaseItem> data;
    private CaseAdapter mAdapter;

    private GridView listView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_case, container, false);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipecase);
        listView = (GridView) view.findViewById(R.id.lvcase);

        listView.setNumColumns(2);

        loadJson();
        swipeRefresh();
        return view;
    }

    private void swipeRefresh() {

        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimaryDark),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimaryDark));

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadJson();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void loadJson() {

        CaseApi caseApi = Caseclient.getApiCase();

        Call<CaseList>  call = caseApi.getCaseData();

        call.enqueue(new Callback<CaseList>() {
            @Override
            public void onResponse(Call<CaseList> call, Response<CaseList> response) {
                if (response.isSuccessful()) {

                    CaseList jsonResponse = response.body();
                    data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));

                    mAdapter = new CaseAdapter(getActivity(), data);

                    listView.setAdapter(mAdapter);
                }
                else {
                    Snackbar.make(parentView ,"", Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CaseList> call, Throwable t) {

            }
        });

    }

}
