package com.example.demo8;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuizServlet", value = "/QuizServlet")
public class QuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String question = request.getParameter("question");
        String selectedOption = request.getParameter("option");
        int questionNumber = 1;
        boolean isSecondOptionSelected = false;
        if (question != null) {
            if (question.equals("question1")) {

                if (selectedOption != null && selectedOption.equals("1")) {
                    questionNumber = 2;
                    request.setAttribute("questionNumber", questionNumber);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);


                } else {
                    request.setAttribute("message", "Вы проиграли. Начните заново!");
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);

                }
            } else if (question.equals("question2")) {
                questionNumber = 3;
                if (selectedOption != null && selectedOption.equals("1")) {
                    request.setAttribute("questionNumber", questionNumber);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);

                } else {
                    request.setAttribute("message", "Вы проиграли. Начните заново!");
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                }
            } else if (question.equals("question3")) {
                questionNumber = 4;
                if (selectedOption != null && selectedOption.equals("1")) {
                    request.setAttribute("questionNumber", questionNumber);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);

                } else {
                    request.setAttribute("message", "Вы проиграли. Начните заново!");
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);


                }
            } else if (question.equals("question4")) {
                isSecondOptionSelected = true;
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h2>Тебя вернули домой. Победа!</h2>");
            }
        }
        if (selectedOption != null && selectedOption.equals("3")) {

            response.sendRedirect("welcome.jsp");


        }  if (selectedOption != null && selectedOption.equals("4")) {
            HttpSession session = request.getSession();
            Integer gamesPlayed = (Integer) session.getAttribute("gamesPlayed");


            if (gamesPlayed == null) {
                gamesPlayed = 1;
            } else {
                gamesPlayed++;
            }
            session.setAttribute("gamesPlayed", gamesPlayed);
            response.sendRedirect("index.jsp");

        }
        if (isSecondOptionSelected) {
            HttpSession session = request.getSession();
            Integer gamesPlayed = (Integer) session.getAttribute("gamesPlayed");


            if (gamesPlayed == null) {
                gamesPlayed = 1;
            } else {
                gamesPlayed++;
            }
            session.setAttribute("gamesPlayed", gamesPlayed);
            response.sendRedirect("index.jsp");

        }
    }


}
