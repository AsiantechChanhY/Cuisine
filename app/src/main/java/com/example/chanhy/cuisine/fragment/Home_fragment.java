package com.example.chanhy.cuisine.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chanhy.cuisine.R;

/**
 * Created by chanhy on 30/05/2016.
 */
public class Home_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view =  inflater.inflate( R.layout.activity_home,container, false);
        return view;
    }
}
