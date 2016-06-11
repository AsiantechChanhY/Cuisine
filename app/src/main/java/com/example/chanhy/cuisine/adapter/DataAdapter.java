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

        Picasso.with(viewHolder.itemView.getContext()).load(data.get(i).getImage()).into(viewHolder.img_profilePic);
        viewHolder.tv_name.setText(data.get(i).getName());
        viewHolder.tv_datetime.setText(data.get(i).getDatetime());
        viewHolder.tvlocation.setText(data.get(i).getLocation());
        viewHolder.tv_userId.setText(data.get(i).getUserId());
        Picasso.with(viewHolder.itemView.getContext()).load(data.get(i).getImage()).into(viewHolder.img_image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name,tv_datetime,tvlocation, tv_userId;
        private ImageView img_image;
        private CircleImageView img_profilePic;

        public ViewHolder(View view) {
            super(view);

            img_profilePic = (CircleImageView)view.findViewById(R.id.profilePic);
            tv_name = (TextView)view.findViewById(R.id.productname);
            tv_datetime = (TextView)view.findViewById(R.id.price);
            tv_userId = (TextView)view.findViewById(R.id.storename);
            tvlocation = (TextView)view.findViewById(R.id.base_price);
            img_image = (ImageView) view.findViewById(R.id.imagenew);

        }
    }

}