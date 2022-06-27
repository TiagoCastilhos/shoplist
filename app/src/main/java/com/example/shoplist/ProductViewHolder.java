package com.example.shoplist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoplist.models.Product;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    private TextView nameView;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        this.nameView = itemView.findViewById(R.id.productName);
    }

    public void setData(Product product) {
        nameView.setText(product.getDescription());
    }
}
