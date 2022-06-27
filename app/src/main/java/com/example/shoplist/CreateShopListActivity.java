package com.example.shoplist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ScrollView;

import com.example.shoplist.data.infrastructure.SqlDatabase;
import com.example.shoplist.data.repositories.ProductsRepository;
import com.example.shoplist.data.repositories.ShopListsRepository;
import com.example.shoplist.models.Product;
import com.example.shoplist.models.ShopList;

import java.util.ArrayList;

public class CreateShopListActivity extends AppCompatActivity {
    private ProductsRepository productsRepository;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_shop_list);

        this.productsRepository = new ProductsRepository(new SqlDatabase(this));
        ArrayList<Product> products = this.productsRepository.getProducts();
        productAdapter = new ProductAdapter(products);

        RecyclerView recyclerView = findViewById(R.id.productsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(productAdapter);

        Button saveShopListButton = findViewById(R.id.saveShopListButton);
        saveShopListButton.setOnClickListener((view) -> {

        });
    }
}