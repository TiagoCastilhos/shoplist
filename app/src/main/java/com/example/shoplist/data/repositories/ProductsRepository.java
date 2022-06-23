package com.example.shoplist.data.repositories;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.shoplist.data.infrastructure.SqlDatabase;
import com.example.shoplist.models.Product;
import com.example.shoplist.models.ShopList;

import java.util.ArrayList;
import java.util.Date;

public class ProductsRepository {
    private SqlDatabase sqlDatabase;

    public ProductsRepository(SqlDatabase sqlDatabase) {
        this.sqlDatabase = sqlDatabase;
    }

    public ArrayList<Product> getProducts() {
        SQLiteDatabase db = sqlDatabase.getReadableDatabase();
        Cursor cursor = db.rawQuery("select Id, Description, Currency, Value from Products", new String[]{});
        cursor.moveToFirst();
        ArrayList<Product> result = new ArrayList<Product>();

        while (!cursor.isAfterLast()) {
            Product product = new Product();
            product.setId(cursor.getInt(0));
            product.setDescription(cursor.getString(1));
            product.setCurrency(cursor.getString(2));
            product.setValue(cursor.getFloat(3));
            result.add(product);

            cursor.moveToNext();
        }

        return result;
    }
}
