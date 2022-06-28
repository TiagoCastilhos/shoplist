package com.example.shoplist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.shoplist.data.infrastructure.SqlDatabase;
import com.example.shoplist.data.repositories.ProductsRepository;
import com.example.shoplist.data.repositories.ShopListsRepository;
import com.example.shoplist.models.Product;

import java.util.ArrayList;

public class ShopListDetailsActivity extends AppCompatActivity {
    private ShopListsRepository shopListsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list_details);

        Integer shopListId = getIntent().getIntExtra("shopListId", 0);
        String shopListName = getIntent().getStringExtra("shopListName");
        TextView shopListNameView = findViewById(R.id.shopListNameView);
        shopListNameView.setText(shopListName);
        SqlDatabase sqlDatabase = new SqlDatabase(this);
        this.shopListsRepository = new ShopListsRepository(sqlDatabase);
        ArrayList<Product> products = this.shopListsRepository.getProducts(shopListId);
        ProductAdapter productAdapter = new ProductAdapter(products);

        RecyclerView recyclerView = findViewById(R.id.productsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(productAdapter);
    }
}