package com.example.shoplist;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoplist.models.ShopList;

import java.time.Instant;
import java.util.Date;

public class ShopListAdapter extends RecyclerView.Adapter<ShopListViewHolder> {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public ShopListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shop_list_layout, parent, false);

        ShopList shopList = new ShopList();
        shopList.setId(1);
        shopList.setDescription("testeeee");
        shopList.setCreationDate(Date.from(Instant.now()));

        return new ShopListViewHolder(view, shopList);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopListViewHolder holder, int position) {
        //holder.getTextView().setText(localDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
