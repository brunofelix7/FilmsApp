package com.example.filmsapp.database;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.filmsapp.database.service.FilmService;
import com.example.filmsapp.model.domain.Film;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class FilmServiceTest {

    private Context context;
    private FilmService service;

    @Before
    public void setUp() {
        this.context = InstrumentationRegistry.getTargetContext().getApplicationContext();
        this.service = new FilmService();
    }

    @Test
    public void saveTest() {


    }

}
