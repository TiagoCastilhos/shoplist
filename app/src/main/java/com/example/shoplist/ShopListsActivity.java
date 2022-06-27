package com.example.shoplist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.shoplist.data.infrastructure.SqlDatabase;
import com.example.shoplist.data.repositories.ShopListsRepository;
import com.example.shoplist.models.ShopList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ShopListsActivity extends AppCompatActivity {
    private ShopListAdapter shopListAdapter;
    private ShopListsRepository shopListsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_lists);

        this.shopListsRepository = new ShopListsRepository(new SqlDatabase(this));
        ArrayList<ShopList> shopLists = this.shopListsRepository.getShopLists();
        shopListAdapter = new ShopListAdapter(shopLists);

        RecyclerView recyclerView = findViewById(R.id.shopListsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(shopListAdapter);

        FloatingActionButton createShopListButton = findViewById(R.id.createShopListButton);
        createShopListButton.setOnClickListener((view) -> {
            Intent intent = new Intent(ShopListsActivity.this, CreateShopListActivity.class);
            startActivity(intent);
        });
    }
}