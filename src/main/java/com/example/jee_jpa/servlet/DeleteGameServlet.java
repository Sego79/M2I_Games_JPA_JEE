package com.example.jee_jpa.servlet;


import com.example.jee_jpa.dao.Dao;
import com.example.jee_jpa.dao.DaoFactory;
import com.example.jee_jpa.model.Game;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/games/delete")
public class DeleteGameServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //On récupère l'id mis en paramètre dans la jsp "list-game"
            String idStr = req.getParameter("IdGame");
         System.out.println(idStr);
            Long id = Long.parseLong(idStr);
            Dao<Game> dao = DaoFactory.getGameDao();
            //GameDao dao = new GameDao();
          //  Optional<Game> game = dao.findById(id);
            //On utilise la méthode de notre DAO
            dao.delete(id);
            resp.sendRedirect(req.getContextPath() + "/games");
    }

}
