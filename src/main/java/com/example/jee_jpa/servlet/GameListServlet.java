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
import java.util.List;


@WebServlet(urlPatterns = "/games")
public class GameListServlet extends HttpServlet {


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                Dao<Game> GameDao = DaoFactory.getGameDao();
                //on récupère les jeux
                List<Game> gameList = GameDao.getAll();
                //on set les attributs sous la forme clé-valeur. La clé sera utilisée dans la JSP
                req.setAttribute("games", gameList);

               //On renvoit les données à la JSP
                req.getRequestDispatcher("WEB-INF/list-game.jsp")
                        .forward(req, resp);

        }

}
