

package com.example.demo8;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuizServlet2", value = "/QuizServlet2")
public class QuizServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String restart = request.getParameter("restart");
        String question = request.getParameter("question");
        String selectedOption = request.getParameter("option");
        int questionNumber = 1;
        boolean isSecondOptionSelected = false;
        if (question != null) {
            if (question.equals("question1")) {

                if (selectedOption != null && selectedOption.equals("1")) {
                    questionNumber = 2;
                    request.setAttribute("questionNumber", questionNumber);
                    request.getRequestDispatcher("welcome2.jsp").forward(request, response);


                } else {
                    isSecondOptionSelected = true;
                    request.setAttribute("message", "Эй ты собераешься учиться?!");
                    request.getRequestDispatcher("welcome2.jsp").forward(request, response);

                }
            } else if (question.equals("question2")) {
                questionNumber = 3;
                if (selectedOption != null && selectedOption.equals("1")) {
                    request.setAttribute("questionNumber", questionNumber);
                    request.getRequestDispatcher("welcome2.jsp").forward(request, response);

                } else {
                    isSecondOptionSelected = true;
                    request.setAttribute("message", "Эй ты собераешься учиться?!");
                    request.getRequestDispatcher("welcome2.jsp").forward(request, response);
                }
            } else if (question.equals("question3")) {
                questionNumber = 4;
                if (selectedOption != null && selectedOption.equals("1")) {
                    request.setAttribute("questionNumber", questionNumber);
                    request.getRequestDispatcher("welcome2.jsp").forward(request, response);

                } else {
                    isSecondOptionSelected = true;
                    request.setAttribute("message", "Эй ты собераешься учиться?!");
                    request.getRequestDispatcher("welcome2.jsp").forward(request, response);


                }
            } else if (question.equals("question4")) {
                isSecondOptionSelected = true;
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h2>Ты станешь программистом!. Победа!</h2>");
            }
        }
        if (isSecondOptionSelected || restart != null && restart.equals("true")) {

            response.sendRedirect("index.jsp");

        }


    }
}


