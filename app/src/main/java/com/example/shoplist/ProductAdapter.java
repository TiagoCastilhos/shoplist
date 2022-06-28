package com.example.shoplist;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoplist.models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private ArrayList<Product> products;
    private HashMap<Integer, Boolean> map;

    public ProductAdapter(ArrayList<Product> products) {
        this.products = products;
        this.map = new HashMap<Integer, Boolean>();
    }

    public HashMap<Integer, Boolean> getHashMap() {
        return this.map;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_layout, parent, false);

        return new ProductViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.setData(this.products.get(position), this.map);
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }
}
