package com.example.shoplist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoplist.models.ShopList;

public class ShopListViewHolder extends RecyclerView.ViewHolder {
    public ShopListViewHolder(@NonNull View itemView, ShopList shopList) {
        super(itemView);
        TextView idView = itemView.findViewById(R.id.shopListIdView);
        idView.setText(shopList.getId());

        TextView nameView = itemView.findViewById(R.id.shopListNameView);
        nameView.setText(shopList.getDescription());
    }
}
