package com.example.filmsapp.ui.filmdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.filmsapp.R;
import com.example.filmsapp.domain.Film;

public class FilmDetailsActivity extends AppCompatActivity {

    public static final String KEY_EXTRA_FILM = "key_extra_film";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);

        Film film = (Film) getIntent().getSerializableExtra(KEY_EXTRA_FILM);
        TextView tv_title = findViewById(R.id.tv_title);
        tv_title.setText(film.getTitle());
    }

}
