package com.example.jee_jpa.servlet;

import com.example.jee_jpa.dao.Dao;
import com.example.jee_jpa.dao.DaoFactory;
import com.example.jee_jpa.dao.GameDao;
import com.example.jee_jpa.model.Game;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/games/add")
public class AddGameServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/add-game.jsp")
                .forward(req, resp); //forward permet d'aller sur la page
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name =  req.getParameter("gameName");
        String description =  req.getParameter("gameDescription");

        System.out.println(name);
        System.out.println(description);
        Game game = new Game(name,description);
        Dao<Game> gameDao = DaoFactory.getGameDao();
        gameDao.save(game);

        resp.sendRedirect(req.getContextPath() + "/games");
        System.out.println("POST /games/add");


    }


}
