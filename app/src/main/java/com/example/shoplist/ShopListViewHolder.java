package com.example.shoplist;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoplist.models.ShopList;

public class ShopListViewHolder extends RecyclerView.ViewHolder {
    private View itemView;
    private TextView idView;
    private TextView nameView;
    private Context context;

    public ShopListViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        this.idView = itemView.findViewById(R.id.shopListIdView);
        this.nameView = itemView.findViewById(R.id.shopListNameView);
        this.context = itemView.getContext();
    }

    public void setData(ShopList shopList) {
        idView.setText(Integer.toString(shopList.getId()));
        nameView.setText(shopList.getDescription());
        this.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ShopListDetailsActivity.class);
            intent.putExtra("shopListId", shopList.getId());
            intent.putExtra("shopListName", shopList.getDescription());
            this.context.startActivity(intent);
        });
    }
}
