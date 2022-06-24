package com.example.shoplist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ShopListsActivity extends AppCompatActivity {
    private ShopListAdapter shopListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_lists);
        shopListAdapter = new ShopListAdapter();

        RecyclerView recyclerView = findViewById(R.id.shopListsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(shopListAdapter);
    }
}