package com.example.chanhy.cuisine.Rest;

import com.example.chanhy.cuisine.Model.BookItem;
import com.example.chanhy.cuisine.Model.CaseItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by chanhy on 21/06/2016.
 */
public class CaseList {

    private CaseItem[] android ;

    public CaseItem[] getAndroid() {
        return android;
    }
}
