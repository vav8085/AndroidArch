package com.example.simpleapp.network.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleapp.R;
import com.example.simpleapp.network.response.Store;

import java.util.List;

public class MainRecyclerviewAdapter extends RecyclerView.Adapter<MainRecyclerviewAdapter.MainViewHolder>{
    private List<Store> stores;

    public MainRecyclerviewAdapter(Context context, List<Store> stores) {
        this.stores = stores;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MainViewHolder(view);
    }

    public void setStore(List<Store> stores){
        this.stores = stores;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        ImageView storeImage;
        TextView heading;
        TextView desc;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            desc = itemView.findViewById(R.id.desc);
        }
    }

}
