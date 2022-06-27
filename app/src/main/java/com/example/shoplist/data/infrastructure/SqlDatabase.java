package com.example.shoplist.data.infrastructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlDatabase extends SQLiteOpenHelper {
    private static final String DatabaseName   = "shoplist2.db";
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
        addProducts(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Products");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ShopLists");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ShopListsProducts");
        onCreate(sqLiteDatabase);
    }

    private void createProductsTable(SQLiteDatabase sqLiteDatabase) {
        StringBuilder sb = new StringBuilder();

        sb.append("CREATE TABLE Products (");
        sb.append(" Id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(" Description TEXT NOT NULL, ");
        sb.append(" Currency TEXT NOT NULL, ");
        sb.append(" Value REAL NOT NULL )");

        sqLiteDatabase.execSQL(sb.toString());
    }

    private void createShopListsTable(SQLiteDatabase sqLiteDatabase) {
        StringBuilder sb = new StringBuilder();

        sb.append("CREATE TABLE ShopLists (");
        sb.append(" Id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(" CreationDate INTEGER NOT NULL, ");
        sb.append(" Description TEXT NOT NULL ) ");

        sqLiteDatabase.execSQL(sb.toString());
    }

    private void createShopListsProductsTable(SQLiteDatabase sqLiteDatabase) {
        StringBuilder sb = new StringBuilder();

        sb.append("CREATE TABLE ShopListsProducts (");
        sb.append(" ProductId INTEGER NOT NULL, ");
        sb.append(" ShopListId INTEGER NOT NULL, ");
        sb.append(" FOREIGN KEY(ProductId) REFERENCES Products(Id), ");
        sb.append(" FOREIGN KEY(ShopListId) REFERENCES ShopLists(Id) ON DELETE CASCADE ) ");

        sqLiteDatabase.execSQL(sb.toString());
    }

    private void addProducts(SQLiteDatabase sqLiteDatabase) {
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO Products (Description, Currency, Value)");
        sb.append(" Values ('Arroz 1Kg', 'R$', 2.69) ");
        sqLiteDatabase.execSQL(sb.toString());

        StringBuilder sb1 = new StringBuilder();

        sb1.append("INSERT INTO Products (Description, Currency, Value)");
        sb1.append(" Values ('Leite longa vida', 'R$', 2.70) ");
        sqLiteDatabase.execSQL(sb1.toString());

        StringBuilder sb2 = new StringBuilder();

        sb2.append("INSERT INTO Products (Description, Currency, Value)");
        sb2.append(" Values ('Carne Friboi', 'R$', 16.70) ");
        sqLiteDatabase.execSQL(sb2.toString());

        StringBuilder sb3 = new StringBuilder();

        sb3.append("INSERT INTO Products (Description, Currency, Value)");
        sb3.append(" Values ('Feijão carioquinha 1Kg', 'R$', 3.38) ");
        sqLiteDatabase.execSQL(sb3.toString());

        StringBuilder sb4 = new StringBuilder();

        sb4.append("INSERT INTO Products (Description, Currency, Value)");
        sb4.append(" Values ('Refrigerante coca-cola 2 litros', 'R$', 3.00) ");
        sqLiteDatabase.execSQL(sb4.toString());
    }
}
