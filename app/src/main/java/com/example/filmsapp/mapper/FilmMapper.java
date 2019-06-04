package com.example.filmsapp.mapper;

import android.os.Build;

import com.example.filmsapp.model.dto.FilmDto;
import com.example.filmsapp.model.domain.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsável por fazer o parse da API
 */
public class FilmMapper {

    public static List<Film> responseFromDomain(List<FilmDto> filmsResponse) {
        final List<Film> films = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            filmsResponse.forEach(f -> films.add(new Film(f.getOriginal_title(), f.getPoster_path())));
        } else {
            for (FilmDto f : filmsResponse) {
                films.add(new Film(f.getOriginal_title(), f.getPoster_path()));
            }
        }
        return films;
    }

}
