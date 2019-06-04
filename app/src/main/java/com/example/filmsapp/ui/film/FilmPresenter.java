package com.example.filmsapp.ui.film;

import com.example.filmsapp.model.dto.FilmResult;
import com.example.filmsapp.mapper.FilmMapper;
import com.example.filmsapp.task.TaskFilm;
import com.example.filmsapp.task.TaskFilmContract;

public class FilmPresenter implements FilmContract.FilmPresenter, TaskFilmContract {

    private FilmActivity mActivity;
    private FilmContract.FilmView view;
    private static final String API_KEY = "0869c06b9999f9f3106978f6ef084181";

    FilmPresenter(FilmActivity mActivity, FilmContract.FilmView view) {
        this.view = view;
        this.mActivity = mActivity;
    }

    @Override
    public void listFilms() {
        new TaskFilm(this.mActivity, this).execute(API_KEY);
    }

    @Override
    public void destroyView() {
        this.view = null;
    }

    @Override
    public void updateUI(FilmResult films) {
        if (films != null) {
            view.showFilms(FilmMapper.responseFromDomain(films.getResults()));
        } else {
            //  Aqui você pode obter o erro e mostrar uma mensagem personalizada de acordo com o código de erro
            view.showError();
        }
    }
}
