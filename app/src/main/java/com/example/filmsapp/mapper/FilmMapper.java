package com.example.filmsapp.mapper;

import android.os.Build;

import com.example.filmsapp.api.response.FilmResponse;
import com.example.filmsapp.domain.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsável por fazer o parse da API
 */
public class FilmMapper {

    public static List<Film> responseFromDomain(List<FilmResponse> filmsResponse) {
        final List<Film> films = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            filmsResponse.forEach(f -> films.add(new Film(f.getOriginal_title(), f.getPoster_path())));
        } else {
            for (FilmResponse f : filmsResponse) {
                films.add(new Film(f.getOriginal_title(), f.getPoster_path()));
            }
        }
        return films;
    }

}
