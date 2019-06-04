package com.example.filmsapp;

import com.example.filmsapp.api.ApiService;
import com.example.filmsapp.model.dto.FilmResult;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ExampleUnitTest {

    @Test
    public void apiTest() throws IOException {
        FilmResult response = ApiService.getInstance().list("0869c06b9999f9f3106978f6ef084181").execute().body();
        assertNotNull(response);
        System.out.println("Test OK");
    }
}