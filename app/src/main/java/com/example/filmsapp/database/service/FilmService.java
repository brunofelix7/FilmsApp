package com.example.filmsapp.database.service;

import android.util.Log;

import com.example.filmsapp.database.dao.FilmDao;
import com.example.filmsapp.model.domain.Film;

import java.util.List;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class FilmService implements FilmDao {

    private static final String TAG = "FilmService";
    private Realm realm;

    public FilmService() {
        this.realm = Realm.getDefaultInstance();
    }

    @Override
    public boolean save(Film film) {
        try {
            realm.beginTransaction();
            realm.copyToRealm(film);
            realm.commitTransaction();
            return true;
        } catch (RealmPrimaryKeyConstraintException e) {
            Log.d(TAG, "save() error - " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            Log.d(TAG, "save() error - " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Film> findAll() {
        List<Film> data;
        try {
            data = realm.where(Film.class).findAll();
            if (data == null) {
                throw new NullPointerException();
            }
            return data;
        } catch (NullPointerException e) {
            Log.d(TAG, "findAll() error - " + e.getMessage());
            return null;
        }
    }

    @Override
    public void clearDatabase() {
        try {
            realm.beginTransaction();
            realm.deleteAll();
            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
            Log.d(TAG, "clearDatabase() error - " + e.getMessage());
        }
    }

    @Override
    public int setPrimaryKey() {
        int primaryKey = 1;
        if (realm.where(Film.class).max("id") != null) {
            primaryKey = realm.where(Film.class).max("id").intValue() + 1;
        }
        return primaryKey;
    }

    @Override
    public void close() {
        realm.close();
    }

}
