package com.example.filmsapp.ui.film;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.filmsapp.R;
import com.example.filmsapp.adapter.FilmAdapter;
import com.example.filmsapp.domain.Film;
import com.example.filmsapp.ui.ConfigActivity;

import java.util.List;

public class FilmActivity extends AppCompatActivity implements ConfigActivity, FilmContract.FilmView {

    private Toolbar toolbar;
    private RecyclerView rv_films;
    private RecyclerView.LayoutManager layoutManager;
    private FilmAdapter adapter;
    private FilmContract.FilmPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        findViews();
        configViews();
        configPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroyView();
    }

    @Override
    public void findViews() {
        toolbar = findViewById(R.id.toolbar);
        rv_films = findViewById(R.id.rv_films);
    }

    @Override
    public void configViews() {
        //  Toolbar
        setSupportActionBar(toolbar);

        //  RecyclerView
        adapter = new FilmAdapter();
        layoutManager = new GridLayoutManager(this, 2);
        rv_films.setLayoutManager(layoutManager);
        rv_films.setAdapter(adapter);
    }

    @Override
    public void configPresenter() {
        presenter = new FilmPresenter(this);
        presenter.listFilms();
    }

    @Override
    public void showFilms(List<Film> films) {
        adapter.setFilms(films);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Erro ao obter lista de filmes", Toast.LENGTH_SHORT);
    }

}
