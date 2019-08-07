package com.example.myapplication.ui;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.network.Movies;
import com.example.myapplication.network.listeners.Observer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AvengersListAdapter extends RecyclerView.Adapter<AvengersListAdapter.AvengersViewHolder> {
    private ArrayList<Movies> movies;
    private Context context;
    private Observer clickListener;

    public AvengersListAdapter(ArrayList<Movies> movies, Context context, Observer listener) {
        this.movies = movies;
        this.context = context;
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public AvengersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        AvengersViewHolder avengersViewHolder = new AvengersViewHolder(view);
        return avengersViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AvengersViewHolder holder, final int position) {
        Picasso.get().load(movies.get(position).getPoster()).placeholder(R.drawable.ic_launcher_background).fit().into(holder.imageView);
        Picasso.get().setLoggingEnabled(true);
        holder.year.setText(movies.get(position).getYear());
        holder.title.setText(movies.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onClick(movies.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    class AvengersViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title;
        TextView year;
        public AvengersViewHolder(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.heading);
            year = itemView.findViewById(R.id.year);
        }
    }
}
