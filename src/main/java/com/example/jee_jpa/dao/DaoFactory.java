package com.example.jee_jpa.dao;

import com.example.jee_jpa.model.Game;

public class DaoFactory {

    private DaoFactory() {
    }

    public static Dao<Game> getGameDao() {
        return new GameDao();
    }




}
