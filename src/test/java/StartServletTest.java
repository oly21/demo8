import com.example.demo8.StartQuizServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class StartServletTest {
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;

    StartQuizServlet startServlet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        startServlet = new StartQuizServlet();
    }

    @Test
    void testDoGet() throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        startServlet.doGet(request, response);

        writer.flush();
        String output = stringWriter.toString();

        assertTrue(output.contains("<form method = 'post'>"));
    }

    @Test
    void testDoPost() throws IOException {
        when(request.getParameter("username")).thenReturn("John Doe");
        when(request.getSession()).thenReturn(session);

        startServlet.doPost(request, response);

        verify(session).setAttribute("username", "John Doe");
        verify(session, times(1)).getAttribute("gamesPlayed");
        verify(session).setAttribute("gamesPlayed", 1);
        verify(response).sendRedirect("welcome.jsp");
    }
}
