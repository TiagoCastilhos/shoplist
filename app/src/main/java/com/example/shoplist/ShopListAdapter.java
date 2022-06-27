package com.example.shoplist;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoplist.models.ShopList;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class ShopListAdapter extends RecyclerView.Adapter<ShopListViewHolder> {
    private ArrayList<ShopList> shopLists;

    public ShopListAdapter(ArrayList<ShopList> shopLists) {
        this.shopLists = shopLists;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public ShopListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shop_list_layout, parent, false);

        return new ShopListViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ShopListViewHolder holder, int position) {
        holder.setData(this.shopLists.get(position));
    }

    @Override
    public int getItemCount() {
        return this.shopLists.size();
    }
}
