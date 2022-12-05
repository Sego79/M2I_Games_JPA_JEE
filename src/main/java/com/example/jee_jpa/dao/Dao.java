package com.example.jee_jpa.dao;

import com.example.jee_jpa.model.Game;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

//    Optional<T> get(Long id);

    Optional<Game> findById(Long id);

    List<T> getAll();

    void save(T t);

    Game update(T t);

    Boolean delete(Long id);
}
