package com.example.filmsapp.model.domain;

import java.io.Serializable;
import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Film extends RealmObject implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String title;
    private String imagePath;

    public Film() {

    }

    public Film(String title, String imagePath) {
        this.title = title;
        this.imagePath = imagePath;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImagePath() {
        return imagePath;
    }

}
