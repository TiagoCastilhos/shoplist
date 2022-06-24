package com.example.shoplist.data.repositories;

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
        SQLiteDatabase db = sqlDatabase.getReadableDatabase();
        Cursor cursor = db.rawQuery("select Id, Description, CreationDate from ShopLists", new String[]{});
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

    public void insertShopList(ShopList shopList) {

    }

    public void addProductToList(int productId, int shopListId) {

    }

    public void removeProductFromList(int productId, int shopListId) {

    }

    public ArrayList<Product> getProducts(int shopListId) {
        return null;
    }
}
