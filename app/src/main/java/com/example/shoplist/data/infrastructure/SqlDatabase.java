package com.example.shoplist.data.infrastructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlDatabase extends SQLiteOpenHelper {
    private static final String DatabaseName   = "shoplist.db";
    private static final int    DatabaseVersion = 1;

    public SqlDatabase(Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("PRAGMA foreign_keys = OFF");
        createProductsTable(sqLiteDatabase);
        createShopListsTable(sqLiteDatabase);
        createShopListsProductsTable(sqLiteDatabase);
        sqLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Products");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ShopLists");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ShopListsProducts");
        onCreate(sqLiteDatabase);
    }

    private void createProductsTable(SQLiteDatabase sqLiteDatabase) {
        StringBuilder stringBuilderCreateTable = new StringBuilder();

        stringBuilderCreateTable.append("CREATE TABLE Products (");
        stringBuilderCreateTable.append(" Id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilderCreateTable.append(" Description TEXT NOT NULL, ");
        stringBuilderCreateTable.append(" Currency TEXT NOT NULL, ");
        stringBuilderCreateTable.append(" Value REAL NOT NULL )");

        sqLiteDatabase.execSQL(stringBuilderCreateTable.toString());
    }

    private void createShopListsTable(SQLiteDatabase sqLiteDatabase) {
        StringBuilder stringBuilderCreateTable = new StringBuilder();

        stringBuilderCreateTable.append("CREATE TABLE ShopLists (");
        stringBuilderCreateTable.append(" Id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilderCreateTable.append(" CreationDate INTEGER NOT NULL, ");
        stringBuilderCreateTable.append(" Description TEXT NOT NULL ) ");

        sqLiteDatabase.execSQL(stringBuilderCreateTable.toString());
    }

    private void createShopListsProductsTable(SQLiteDatabase sqLiteDatabase) {
        StringBuilder stringBuilderCreateTable = new StringBuilder();

        stringBuilderCreateTable.append("CREATE TABLE ShopListsProducts (");
        stringBuilderCreateTable.append(" ProductId INTEGER NOT NULL, ");
        stringBuilderCreateTable.append(" ShopListId INTEGER NOT NULL, ");
        stringBuilderCreateTable.append(" FOREIGN KEY(ProductId) REFERENCES Products(Id), ");
        stringBuilderCreateTable.append(" FOREIGN KEY(ShopListId) REFERENCES ShopLists(Id) ON DELETE CASCADE ) ");

        sqLiteDatabase.execSQL(stringBuilderCreateTable.toString());
    }
}
