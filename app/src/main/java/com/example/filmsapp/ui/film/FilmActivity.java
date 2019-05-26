package com.example.filmsapp.ui.film;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.filmsapp.R;
import com.example.filmsapp.adapter.FilmAdapter;
import com.example.filmsapp.domain.Film;
import com.example.filmsapp.listener.ItemFilmClickListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EActivity(R.layout.activity_film)
public class FilmActivity extends AppCompatActivity implements FilmContract.FilmView, ItemFilmClickListener {

    @ViewById
    protected Toolbar toolbar;

    @ViewById
    protected RecyclerView rv_films;

    protected FilmAdapter adapter;
    protected FilmContract.FilmPresenter presenter;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroyView();
    }

    @AfterViews
    protected void initializeViews() {
        setSupportActionBar(toolbar);

        adapter = new FilmAdapter(this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        rv_films.setLayoutManager(layoutManager);
        rv_films.setAdapter(adapter);

        presenterConfig();
    }

    protected void presenterConfig() {
        presenter = new FilmPresenter(this);
        presenter.listFilms();
    }

    @Override
    public void showFilms(List<Film> films) {
        adapter.setFilms(films);
    }

    @SuppressLint("ShowToast")
    @Override
    public void showError() {
        Toast.makeText(this, "Erro ao obter lista de filmes", Toast.LENGTH_SHORT);
    }

    @Override
    public void onItemFilmClick(Film film) {
        Intent intent = new Intent(this, FilmDetailsActivity.class);
        intent.putExtra(FilmDetailsActivity.KEY_EXTRA_FILM, film);
        startActivity(intent);
    }

}
