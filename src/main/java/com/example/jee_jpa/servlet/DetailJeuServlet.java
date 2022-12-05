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
import java.util.Optional;

@WebServlet(urlPatterns = "/games/details")
public class DetailJeuServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dao<Game> gameDao = DaoFactory.getGameDao();
        //GameDao gameDao = new GameDao();
        //On récupère l'id mis en paramètre dans la jsp "list-game"
        Long id = Long.valueOf(req.getParameter("id"));
        Optional<Game> game = gameDao.findById(id);
        //On récupère les infos de notre entité game :
        String name = game.get().getName();
        String description = game.get().getDescription();
        //On met à jour ses infos pour l'envoi à la JSP
        req.setAttribute("id", id);
        req.setAttribute("name", name);
        req.setAttribute("description", description);
        //On envoi notre requête à la jsp pour affichage
        req.getRequestDispatcher("/WEB-INF/detail-game.jsp").forward(req, resp);
    }


}
