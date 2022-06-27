package com.example.shoplist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoplist.models.ShopList;

public class ShopListViewHolder extends RecyclerView.ViewHolder {
    private TextView idView;
    private TextView nameView;

    public ShopListViewHolder(@NonNull View itemView) {
        super(itemView);
        this.idView = itemView.findViewById(R.id.shopListIdView);
        this.nameView = itemView.findViewById(R.id.shopListNameView);
    }

    public void setData(ShopList shopList) {
        idView.setText(Integer.toString(shopList.getId()));
        nameView.setText(shopList.getDescription());
    }
}
