package com.example.chanhy.cuisine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chanhy.cuisine.Model.AndroidVersion;
import com.example.chanhy.cuisine.R;
import com.example.chanhy.cuisine.widget.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<AndroidVersion> data;
    private Context context;

    public DataAdapter(ArrayList<AndroidVersion> data) {
        this.data = data;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        Picasso.with(viewHolder.itemView.getContext()).load(data.get(i).getImage()).into(viewHolder.mProfilePic);
        viewHolder.mName.setText(data.get(i).getName());
//        viewHolder.mDatetime
//                .setText(data.get(i).getDatetime());
        viewHolder.mLocation.setText(data.get(i).getLocation());
//        viewHolder.mUserId.setText(data.get(i).getUserId());
        Picasso.with(viewHolder.itemView.getContext()).load(data.get(i).getImage()).into(viewHolder.mImageBook);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mName,mDatetime,mLocation, mUserId;
        private ImageView mImageBook;
        private CircleImageView mProfilePic;

        public ViewHolder(View view) {
            super(view);

            mProfilePic = (CircleImageView)view.findViewById(R.id.imgprofilePic);
            mName = (TextView)view.findViewById(R.id.tvproductname);
//            mDatetime = (TextView)view.findViewById(R.id.tvdatetime);
//            mUserId = (TextView)view.findViewById(R.id.tvuserid);
            mLocation = (TextView)view.findViewById(R.id.tvlocation);
            mImageBook = (ImageView) view.findViewById(R.id.imgimagenew);

        }
    }

}