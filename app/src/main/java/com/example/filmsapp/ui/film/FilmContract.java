package com.example.filmsapp.ui.film;

import com.example.filmsapp.domain.Film;

import java.util.List;

public interface FilmContract {

    interface FilmView {

        void showFilms(List<Film> films);
        void showError();

    }

    interface FilmPresenter {

        void listFilms();
        void destroyView();

    }

}
