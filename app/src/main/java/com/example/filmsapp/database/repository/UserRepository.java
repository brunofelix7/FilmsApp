package com.example.filmsapp.database.repository;

import com.example.filmsapp.model.domain.User;

import java.util.List;

public interface UserRepository {

    long save(User user);
    List<User> find(String query);
    List<User> findAll();
    void clear();

}
