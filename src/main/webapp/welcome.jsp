<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<h1>Welcome, <%= session.getAttribute("username") %>!</h1>
<h1>Text Adventure Quiz</h1>

<%-- Question 1 --%>

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
<form action="QuizServlet" method="post">
    <input type="hidden" name="restart" value="true">
    <input type="submit" value="Начать заново">
</form>
<%
} else {
%>
<form action="QuizServlet" method="post">
    <% if (questionNumber == 1) { %>
    <input type="hidden" name="question" value="question1">
    Ты потерял память, принять вызов нло?<br>
    <input type="radio" name="option" value="1"> Принять вызов<br>
    <input type="radio" name="option" value="2"> Отклонить вызов<br>
    <% } else if (questionNumber == 2) { %>
    <input type="hidden" name="question" value="question2">
    Ты принял вызов, поднимешься на мостик к капитану?<br>
    <input type="radio" name="option" value="1"> Подняться на мостик<br>
    <input type="radio" name="option" value="2"> Отказаться<br>
    <% } else if (questionNumber == 3) { %>
    <input type="hidden" name="question" value="question3">
    Ты поднялся на мостик, ответь им, кто ты?<br>
    <input type="radio" name="option" value="1"> Рассказать о себе правду<br>
    <input type="radio" name="option" value="2"> Солгать<br>
    <% } else if (questionNumber == 4) { %>
    <input type="hidden" name="question" value="question4">
    Тебя вернули домой. Победа!<br>
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

<!-- Вывод статистики в рамке -->
<div class="statistic">
    <p>Имя игрока: <%= session.getAttribute("username") %>
    </p>
    <p>Количество сыгранных игр: <%= session.getAttribute("gamesPlayed") %>
    </p>
</div>
</body>
</html>
