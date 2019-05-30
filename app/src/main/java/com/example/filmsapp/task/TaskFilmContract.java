package com.example.filmsapp.task;

import com.example.filmsapp.api.response.FilmResult;
import com.example.filmsapp.domain.Film;

import java.util.List;

public interface TaskFilmContract {

    void updateUI(FilmResult films);

}
