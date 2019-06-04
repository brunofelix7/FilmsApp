package com.example.filmsapp.api;

import com.example.filmsapp.model.dto.FilmResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmService {

    @GET("movie/popular")
    Call<FilmResult> list(@Query("api_key") String api_key);

}
