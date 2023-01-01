package io.youka.osgi.hello_jaxrs.provider;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HelloStaticServletTest {
    @Test
    void testFavicon() {
        assertNotNull(
            this.getClass().getResourceAsStream("/www/favicon.png"),
            "favicon.png resource not found!"
        );
    }
}
