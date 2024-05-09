package dev.youka.my.provider;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MyProviderTest {
    @Test
    void testPrintHello() {
        assertDoesNotThrow(new MyProvider()::printHello);
    }
}
