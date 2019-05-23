package com.example.filmsapp.ui.film;

import com.example.filmsapp.api.ApiService;
import com.example.filmsapp.api.response.FilmResult;
import com.example.filmsapp.mapper.FilmMapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmPresenter implements FilmContract.FilmPresenter {

    private FilmContract.FilmView view;
    private static final String API_KEY = "0869c06b9999f9f3106978f6ef084181";

    FilmPresenter(FilmContract.FilmView view) {
        this.view = view;
    }

    @Override
    public void listFilms() {
        ApiService.getInstance().list(API_KEY).enqueue(new Callback<FilmResult>() {
            @Override
            public void onResponse(Call<FilmResult> call, Response<FilmResult> response) {
                if (response.isSuccessful()) {
                    view.showFilms(FilmMapper.responseFromDomain(response.body().getResults()));
                } else {
                    //  Aqui você pode obter o erro e mostrar uma mensagem personalizada de acordo com o código de erro
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<FilmResult> call, Throwable t) {
                view.showError();
            }
        });
    }

    @Override
    public void destroyView() {
        this.view = null;
    }

}
