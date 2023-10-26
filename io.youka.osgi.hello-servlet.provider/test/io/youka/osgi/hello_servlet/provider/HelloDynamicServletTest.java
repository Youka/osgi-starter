package io.youka.osgi.hello_servlet.provider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class HelloDynamicServletTest {
    @Test
    void testGetHello() throws IOException {
        // Mock
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        StringWriter stringWriter = new StringWriter();
        Mockito.when(response.getWriter()).thenReturn(new PrintWriter(stringWriter));

        // Test
        Assertions.assertDoesNotThrow(() -> new HelloDynamicServlet().doGet(request, response));
        Assertions.assertEquals("Hello world", stringWriter.toString());
    }
}
