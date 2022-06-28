package com.example.shoplist;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import com.example.shoplist.data.infrastructure.SqlDatabase;
import com.example.shoplist.data.repositories.ProductsRepository;
import com.example.shoplist.data.repositories.ShopListsRepository;
import com.example.shoplist.models.Product;
import com.example.shoplist.models.ShopList;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Map;

public class CreateShopListActivity extends AppCompatActivity {
    private ProductsRepository productsRepository;
    private ShopListsRepository shopListsRepository;
    private ProductAdapter productAdapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_shop_list);
        SqlDatabase sqlDatabase = new SqlDatabase(this);
        this.productsRepository = new ProductsRepository(sqlDatabase);
        this.shopListsRepository = new ShopListsRepository(sqlDatabase);
        ArrayList<Product> products = this.productsRepository.getProducts();
        productAdapter = new ProductAdapter(products);

        RecyclerView recyclerView = findViewById(R.id.productsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(productAdapter);

        Button saveShopListButton = findViewById(R.id.saveShopListButton);
        saveShopListButton.setOnClickListener(view -> this.onCreateShopListClick(view));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void onCreateShopListClick(View v) {
        ArrayList<Integer> productsIds = new ArrayList<>();

        for (Map.Entry<Integer, Boolean> keyValue: productAdapter.getHashMap().entrySet()){
            if (keyValue.getValue())
                productsIds.add(keyValue.getKey());
        }

        EditText shopListNameView = findViewById(R.id.shopListName);
        ShopList shopList = new ShopList();
        shopList.setDescription(shopListNameView.getText().toString());
        shopList.setCreationDate(Date.from(Instant.now()));

        this.shopListsRepository.insertShopList(shopList, productsIds);
        Intent intent = new Intent(CreateShopListActivity.this, ShopListsActivity.class);
        startActivity(intent);
    }
}