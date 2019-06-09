package com.example.filmsapp.database.config;

import android.app.Application;

import com.example.filmsapp.core.Constants;
import com.example.filmsapp.model.domain.DaoMaster;
import com.example.filmsapp.model.domain.DaoSession;

public class DBConfigApp extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        daoSession = new DaoMaster(new DBConfig(this, Constants.DB_NAME).getWritableDb()).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
