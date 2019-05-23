package com.example.filmsapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filmsapp.R;
import com.example.filmsapp.domain.Film;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private List<Film> films;

    public FilmAdapter() {
        this.films = new ArrayList<>();
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int i) {
        holder.bind(films.get(i));
    }

    @Override
    public int getItemCount() {
        return (films != null && films.size() > 0) ? films.size() : 0;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    /**
     * Class ViewHolder
     */
    static class FilmViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private ImageView iv_path;

        FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            iv_path = itemView.findViewById(R.id.iv_path);
        }

        void bind(Film film) {
            tv_title.setText(film.getTitle());
            Picasso.get().load("https://image.tmdb.org/t/p/w342/" + film.getImagePath()).into(iv_path);
        }
    }

}
