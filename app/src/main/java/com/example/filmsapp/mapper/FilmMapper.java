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

    public static List<Film> responseFromDomain(List<FilmResponse> filmResponses) {
        final List<Film> films = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            filmResponses.forEach(f -> films.add(new Film(f.getOriginal_title(), f.getPoster_path())));
        } else {
            for (FilmResponse f : filmResponses) {
                films.add(new Film(f.getOriginal_title(), f.getPoster_path()));
            }
        }
        return films;
    }

}
