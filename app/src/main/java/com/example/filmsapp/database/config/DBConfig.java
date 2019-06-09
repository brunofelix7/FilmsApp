package com.example.filmsapp.database.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.filmsapp.core.Constants;
import com.example.filmsapp.model.domain.DaoMaster;

import org.greenrobot.greendao.database.Database;

public class DBConfig extends DaoMaster.OpenHelper {

    public DBConfig(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        super.onCreate(db);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        if(oldVersion < newVersion) {
            DaoMaster.dropAllTables(db, true);
            DaoMaster.createAllTables(db, true);
            Log.d(Constants.TAG, "Database oldVersion: " + oldVersion);
            Log.d(Constants.TAG, "Database newVersion: " + newVersion);
        }
    }
}
