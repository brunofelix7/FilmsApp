package com.example.filmsapp.domain;

import java.io.Serializable;

public class Film implements Serializable {

    private String title;
    private String imagePath;

    public Film(String title, String imagePath) {
        this.title = title;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public String getImagePath() {
        return imagePath;
    }

}
