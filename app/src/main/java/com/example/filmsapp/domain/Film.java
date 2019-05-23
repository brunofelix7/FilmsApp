package com.example.filmsapp.domain;

public class Film {

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
