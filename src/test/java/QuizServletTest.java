import com.example.demo8.QuizServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class QuizServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDispatcher;
    private QuizServlet quizServlet;

    @BeforeEach
    void setUp() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        requestDispatcher = mock(RequestDispatcher.class);
        quizServlet = new QuizServlet();
    }

    @Test
    void testDoPost_question1SelectedOption1() throws ServletException, IOException {

        when(request.getParameter("question")).thenReturn("question1");
        when(request.getParameter("option")).thenReturn("1");
        when(request.getAttribute("questionNumber")).thenReturn(1);
        when(request.getRequestDispatcher("welcome.jsp")).thenReturn(requestDispatcher);

        quizServlet.doPost(request, response);

        verify(request, times(1)).setAttribute("questionNumber", 2);
        verify(requestDispatcher, times(1)).forward(request, response);
    }



}
