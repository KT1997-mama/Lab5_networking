package com.example.lab5_networking.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lab5_networking.DetailActivity;
import com.example.lab5_networking.R;
import com.example.lab5_networking.model.Value;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.onViewHolder> {
    List<Value> mList;
    Context context;
    public void setData(List<Value> list,Context context) {
        this.mList = list;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public onViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_recycle, parent, false);
        return new onViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.onViewHolder holder, int position) {
      Value value = mList.get(position);
      if (value == null){
          return;
      }
      if (value.getUrl() != null){
        //  Picasso.get().load(value.getUrl()).into(holder.imageView);
          Glide.with(context).load(value.getUrl()).into(holder.imageView);
          holder.imageView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(context, DetailActivity.class);
                  Bundle bundle = new Bundle();
                  bundle.putSerializable("aa",value);
                  intent.putExtras(bundle);
                  context.startActivity(intent);
              }
          });
      }
    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public class onViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txt;
        public onViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            txt = itemView.findViewById(R.id.txtTotal);
        }
    }
}
