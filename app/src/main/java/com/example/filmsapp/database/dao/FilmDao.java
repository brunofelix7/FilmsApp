package com.example.filmsapp.database.dao;

import com.example.filmsapp.model.domain.Film;

import java.util.List;

public interface FilmDao {

    boolean save(final Film film);
    List<Film> findAll();
    void clearDatabase();
    int setPrimaryKey();
    void close();

}
