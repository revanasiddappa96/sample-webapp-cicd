package com.example;

import static org.mockito.Mockito.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

public class HelloServletTest {

    @Test
    void testDoGet() throws Exception {

        // Create servlet instance
        HelloServlet servlet = new HelloServlet();

        // Mock request and response
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Capture output
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        // Call servlet method
        servlet.doGet(request, response);

        writer.flush();

        String result = stringWriter.toString();

        // Assertions
        assert(result.contains("Deployment Successful!"));
        assert(result.contains("GitHub"));
        assert(result.contains("Jenkins"));
        assert(result.contains("Docker"));
        assert(result.contains("Tomcat"));

        // Verify response type set
        verify(response).setContentType("text/html");
    }
}
