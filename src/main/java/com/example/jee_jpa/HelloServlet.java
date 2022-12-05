package com.example.jee_jpa;

import java.io.*;
import java.util.List;

import com.example.jee_jpa.dao.Dao;
import com.example.jee_jpa.dao.DaoFactory;
import com.example.jee_jpa.model.Game;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("début sego");
        //On passe par notre Factory pour instancier notre entité
        Dao<Game> GameDao = DaoFactory.getGameDao();
        //on récupère les jeux
        List<Game> gameList = GameDao.getAll();
        //on set les attributs sous la forme clé-valeur. La clé sera utilisée dans la JSP
        request.setAttribute("games", gameList);

        //Affichage sur console :
        gameList.forEach(game -> {
            System.out.println(game.getId() + " - " + game.getName() + " - " + game.getDescription());
        });
        System.out.println(gameList);
        System.out.println("essai sego");
        response.setContentType("text/html");

                // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        out.println("</body></html>");
    }

    public void destroy() {
    }
}