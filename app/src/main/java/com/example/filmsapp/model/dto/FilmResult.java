package com.example.filmsapp.model.dto;

import com.squareup.moshi.Json;
import java.util.List;

public class FilmResult {

    @Json(name = "results")
    private final List<FilmDto> results;

    public FilmResult(List<FilmDto> results) {
        this.results = results;
    }

    public List<FilmDto> getResults() {
        return results;
    }
}
