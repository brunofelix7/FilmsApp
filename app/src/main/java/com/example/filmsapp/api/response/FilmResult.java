package com.example.filmsapp.api.response;

import com.squareup.moshi.Json;
import java.util.List;

public class FilmResult {

    @Json(name = "results")
    private final List<FilmResponse> results;

    public FilmResult(List<FilmResponse> results) {
        this.results = results;
    }

    public List<FilmResponse> getResults() {
        return results;
    }
}
