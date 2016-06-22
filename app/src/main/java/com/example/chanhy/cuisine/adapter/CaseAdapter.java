package com.example.chanhy.cuisine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chanhy.cuisine.Model.CaseItem;
import com.example.chanhy.cuisine.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by chanhy on 20/06/2016.
 */
public class CaseAdapter extends ArrayAdapter<CaseItem> {

    List<CaseItem> caseItems;
    Context context;
    private LayoutInflater mInflater;

    public CaseAdapter(Context context, List<CaseItem> objects) {
        super(context, 0 , objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        caseItems = objects;
    }

    @Override
    public CaseItem getItem(int position) {
        return caseItems.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            View view = mInflater.inflate(R.layout.case_item, parent, false);

            holder = ViewHolder.create((RelativeLayout) view);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        CaseItem caseItem = getItem(position);

        holder.mTvNameCase.setText(caseItem.getLocation());
        holder.mTvLocation.setText(caseItem.getName());
        Picasso.with(context).load(caseItem.getImage()).into(holder.mImageCase);

        return holder.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView mImageCase;
        public final TextView mTvNameCase;
        public final TextView mTvLocation;

        public ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName, TextView textViewLocation) {
            this.rootView = rootView;
            this.mImageCase = imageView;
            this.mTvNameCase = textViewName;
            this.mTvLocation = textViewLocation;
        }

        public static final ViewHolder create(RelativeLayout relativeLayout){
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.imgCase);
            TextView tvcasename = (TextView) relativeLayout.findViewById(R.id.tvcasename);
            TextView tvcaselocation = (TextView) relativeLayout.findViewById(R.id.tvcaselocation);

            return new ViewHolder(relativeLayout, imageView, tvcaselocation, tvcasename);

        }

    }

}
