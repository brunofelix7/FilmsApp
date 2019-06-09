package com.example.filmsapp.database.service;

import android.app.Application;
import android.util.Log;

import com.example.filmsapp.core.Constants;
import com.example.filmsapp.database.config.DBConfigApp;
import com.example.filmsapp.database.repository.UserRepository;
import com.example.filmsapp.model.domain.DaoSession;
import com.example.filmsapp.model.domain.User;
import com.example.filmsapp.model.domain.UserDao;

import java.util.List;

public class UserService implements UserRepository {

    private DaoSession daoSession;

    public UserService(Application context) {
        daoSession = ((DBConfigApp) context).getDaoSession();
    }

    @Override
    public long save(User user) {
        try {
            if (user == null) {
                throw new NullPointerException("Objeto 'user' é nulo");
            }
            return daoSession.getUserDao().insert(user);
        } catch (NullPointerException e) {
            Log.d(Constants.TAG, e.getMessage());
            return 0;
        }
    }

    @Override
    public List<User> find(String query) {
        List<User> list;
        try {
            if (query == null) {
                throw new NullPointerException("Parâmetro de '@query' pesquisa não pode ser nulo");
            }
            list = daoSession.getUserDao().queryBuilder()
                    .where(UserDao.Properties.Username.eq(query))
                    .orderAsc(UserDao.Properties.Username)
                    .list();
            if (list == null) {
                throw new NullPointerException("Nenhum usuário encontrado");
            }
            return list;
        } catch (NullPointerException e) {
            Log.d(Constants.TAG, e.getMessage());
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        List<User> list;
        try {
            list = daoSession.getUserDao().queryBuilder().list();
            if (list == null) {
                throw new NullPointerException("Nenhum usuário encontrado");
            }
            return list;
        } catch (NullPointerException e) {
            Log.d(Constants.TAG, e.getMessage());
            return null;
        }
    }

    @Override
    public void clear() {
        daoSession.clear();
    }
}
