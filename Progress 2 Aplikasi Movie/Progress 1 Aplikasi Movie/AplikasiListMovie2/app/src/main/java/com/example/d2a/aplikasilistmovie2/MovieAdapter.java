package com.example.d2a.aplikasilistmovie2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private final ArrayList<BuildMovie> movie;

    private LayoutInflater mInflater;
    public MovieAdapter(Context ct,ArrayList<BuildMovie> s1){
        mInflater = LayoutInflater.from(ct);
        this.movie = s1;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View MyView= mInflater.inflate(R.layout.daftarmovie,parent,false);
        return new MovieHolder(MyView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieHolder holder, int position) {
        BuildMovie mCurrent = movie.get(position);
        holder.t1.setText(mCurrent.title);
        holder.t2.setText(mCurrent.rating);
        holder.t3.setText(mCurrent.status);



    }

    @Override
    public int getItemCount() { return movie.size(); }

    public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView t1,t2,t3;
        final MovieAdapter mAdapter;
        Context context;
        public MovieHolder(View itemView,MovieAdapter adapter) {
            super(itemView);
            t1 = itemView.findViewById(R.id.title);
            t2 = itemView.findViewById(R.id.rating);
            t3 = itemView.findViewById(R.id.status);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int mPosition = getLayoutPosition();
            BuildMovie element = movie.get(mPosition);

            mAdapter.notifyDataSetChanged();
        }
    }
}
