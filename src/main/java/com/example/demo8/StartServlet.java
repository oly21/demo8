package com.example.demo8;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "startServlet", value = "/start-servlet")
public class StartServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Before starting the game you need to enter your name";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<form method = 'post'>");
        out.println("<input type = 'text' name = 'username'>");
        out.println("<input type = 'submit' value = 'start game'>");
        out.println("</form");
        out.println("</body></html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        Integer gamesPlayed = (Integer) session.getAttribute("gamesPlayed");


        if (gamesPlayed == null) {
            gamesPlayed = 1;
        } else {
            gamesPlayed++;
        }

// Сохранение обновленного значения в атрибуте сессии
        session.setAttribute("gamesPlayed", gamesPlayed);
        response.sendRedirect("welcome.jsp");
    }
}