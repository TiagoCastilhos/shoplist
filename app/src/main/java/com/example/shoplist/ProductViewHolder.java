package com.example.shoplist;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoplist.models.Product;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    private int productId;
    private boolean isChecked;
    private TextView nameView;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        this.nameView = itemView.findViewById(R.id.productName);

        this.isChecked = false;

    }

    public void setData(Product product, HashMap<Integer, Boolean> map) {
        this.productId = product.getId();
        nameView.setText(product.getDescription());
        CheckBox checkBox = itemView.findViewById(R.id.checkBox);
        checkBox.setOnClickListener(view -> {
            this.isChecked = !this.isChecked;
            map.put(this.productId, this.isChecked);
        });
    }
}
