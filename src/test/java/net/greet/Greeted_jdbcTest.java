package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Greeted_jdbcTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void greeted() {
        Greeted_jdbc greet = new Greeted_jdbc();

        System.out.println(greet.counterForUser("vuyo"));
        assertEquals(2, greet.counter());
    }
}