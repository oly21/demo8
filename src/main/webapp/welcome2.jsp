<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<h1>Welcome, <%= session.getAttribute("username") %>!</h1>
<h1>Text Adventure Quiz</h1>



<%
    int questionNumber = 0;

    if (request.getAttribute("questionNumber") != null) {
        questionNumber = (int) request.getAttribute("questionNumber");
    } else {
        questionNumber = 1;
    }
%>

<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
<h2><%= message %>
</h2>
<form action="QuizServlet2" method="post">
    <input type="hidden" name="restart" value="true">
    <input type="submit" value="Начать заново">
</form>
<%
} else {
%>
<form action="QuizServlet2" method="post">
    <% if (questionNumber == 1) { %>
    <input type="hidden" name="question" value="question1">
    Ты хочешь стать программистом?<br>
    <input type="radio" name="option" value="1"> да<br>
    <input type="radio" name="option" value="2"> нет<br>
    <% } else if (questionNumber == 2) { %>
    <input type="hidden" name="question" value="question2">
    Ты решил стать программистом, сколько дней  в неделю ты будешь учиться?<br>
    <input type="radio" name="option" value="1"> 5<br>
    <input type="radio" name="option" value="2"> 2<br>
    <% } else if (questionNumber == 3) { %>
    <input type="hidden" name="question" value="question3">
   Сколько часов в день ты будешь заниматься?<br>
    <input type="radio" name="option" value="1"> 2-4<br>
    <input type="radio" name="option" value="2"> 0<br>
    <% } else if (questionNumber == 4) { %>
    <input type="hidden" name="question" value="question4">
    Ты станешь программистом! Победа!<br>
    <% } %>
    <input type="submit" value="Далее">
</form>
<%
    }
%>


<style>
    .statistic {
        border: 1px solid black;
        padding: 10px;
    }
</style>


<div class="statistic">
    <p>Имя игрока: <%= session.getAttribute("username") %>
    </p>
    <p>Количество сыгранных игр: <%= session.getAttribute("gamesPlayed") %>
    </p>
</div>
</body>
</html>
