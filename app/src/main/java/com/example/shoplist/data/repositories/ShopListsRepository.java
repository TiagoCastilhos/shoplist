package com.example.shoplist.data.repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.shoplist.data.infrastructure.SqlDatabase;
import com.example.shoplist.models.Product;
import com.example.shoplist.models.ShopList;

import java.util.ArrayList;
import java.util.Date;

public class ShopListsRepository {
    private SqlDatabase sqlDatabase;

    public ShopListsRepository(SqlDatabase sqlDatabase) {
        this.sqlDatabase = sqlDatabase;
    }

    public ArrayList<ShopList> getShopLists() {
        SQLiteDatabase db = this.sqlDatabase.getReadableDatabase();
        Cursor cursor = db.rawQuery("select Id, Description, CreationDate from ShopLists order by CreationDate Desc", new String[]{});
        cursor.moveToFirst();
        ArrayList<ShopList> result = new ArrayList<>();

        while (!cursor.isAfterLast()) {
            ShopList shopList = new ShopList();
            shopList.setId(cursor.getInt(0));
            shopList.setDescription(cursor.getString(1));
            shopList.setCreationDate(new Date(cursor.getInt(2)));
            result.add(shopList);

            cursor.moveToNext();
        }

        return result;
    }

    public void insertShopList(ShopList shopList, ArrayList<Integer> products) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("CreationDate", shopList.getCreationDate().getTime());
        contentValues.put("Description", shopList.getDescription());
        long id = this.sqlDatabase.getWritableDatabase().insert("ShopLists", null, contentValues);

        for (Integer product: products) {
            contentValues = new ContentValues();
            contentValues.put("ProductId", product);
            contentValues.put("ShopListId", id);
            this.sqlDatabase.getWritableDatabase().insert("ShopListsProducts", null, contentValues);
        }
    }

    public ArrayList<Product> getProducts(int shopListId) {
        SQLiteDatabase db = sqlDatabase.getReadableDatabase();
        Cursor cursor = db.rawQuery("select P.Description, P.Currency, P.Value from Products as P " +
                                            "left join ShopListsProducts as SLP on P.Id = SLP.ProductId " +
                                            "left join ShopLists as SL on SLP.ShopListId = SL.Id " +
                                            "where SL.Id = ?", new String[]{ String.valueOf(shopListId) });
        cursor.moveToFirst();
        ArrayList<Product> result = new ArrayList<Product>();

        while (!cursor.isAfterLast()) {
            Product product = new Product();
            product.setDescription(cursor.getString(0));
            product.setCurrency(cursor.getString(1));
            product.setValue(cursor.getFloat(2));
            result.add(product);

            cursor.moveToNext();
        }

        return result;
    }
}
