# Quiz Application

This is a web-based quiz application that allows users to play different quizzes.

## Project Structure

The project consists of the following servlet classes:

- `QuizServlet`: Handles the quiz logic for the first quiz.
- `QuizServlet2`: Handles the quiz logic for the second quiz.
- `StartQuizServlet`: Handles the starting point of the quiz by taking the user's name and quiz number.
   Also the project consists of the following jsp pages
- `index.jsp` - starting  
- `welcome.jsp`- Handles the quiz logic for the first quiz. contains information for the first quiz.
- `welcome2.jsp` - Handles the quiz logic for the second quiz. contains information  for the second quiz
-JUNIT tests ` QuizServletTest`, `StartServletTest`
## Local Setup

To run this project locally, follow these steps:

1. Install a servlet container such as Apache Tomcat.
2. Deploy the application by placing the WAR file in the servlet container's `webapps` directory.
3. Start the servlet container.



The program starts with the  users name and number of the quest, 
`there are 2 quests` in total, there is a welcome page, the `user 
is welcomed by name`, `the quest can be restarted`  if you lose or win,
y`ou can choose another quest `if you lose or win, the player’s
`name and the number of played games are also displayed on the screen games`. 




