package com.example.filmsapp.task;

import android.os.AsyncTask;
import android.view.View;

import com.example.filmsapp.api.ApiService;
import com.example.filmsapp.api.response.FilmResult;
import com.example.filmsapp.ui.film.FilmActivity;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class TaskFilm extends AsyncTask<String, String, FilmResult> {

    private FilmActivity activity;
    private TaskFilmContract taskContract;

    public TaskFilm(FilmActivity mActivity, TaskFilmContract taskContract) {
        WeakReference<FilmActivity> weakReference = new WeakReference<>(mActivity);
        this.taskContract = taskContract;
        this.activity = weakReference.get();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (activity == null) {
            return;
        }
        activity.rv_films.setVisibility(View.GONE);
        activity.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected FilmResult doInBackground(String... api_key) {
        publishProgress("Carregando...");
        FilmResult response;
        try {
            response = ApiService.getInstance().list(api_key[0]).execute().body();
            if (response == null) {
                return null;
            }
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        if (activity == null) {
            return;
        }
        activity.progressBar.setProgress(100);
    }

    @Override
    protected void onPostExecute(FilmResult films) {
        super.onPostExecute(films);
        taskContract.updateUI(films);
        if (activity == null) {
            return;
        }
        activity.rv_films.setVisibility(View.VISIBLE);
        activity.progressBar.setVisibility(View.GONE);
    }

}
