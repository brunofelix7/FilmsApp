package com.example.filmsapp.model.dto;

import com.squareup.moshi.Json;

public class FilmDto {

    @Json(name = "poster_path")
    private final String poster_path;

    @Json(name = "original_title")
    private final String original_title;

    public FilmDto(String poster_path, String original_title) {
        this.poster_path = poster_path;
        this.original_title = original_title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

}
