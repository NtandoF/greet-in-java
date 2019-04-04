package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

        @Test
      public void ShouldGreetAUserInEnglishTest() {
            Greet greet = new Greet("English", "Ntando");
            assertEquals(greet.greetPerson(), "Hello Ntando!");
        }
    @Test
    public void ShouldGreetAUserInXhosaTest() {
        Greet greet = new Greet("Xhosa", "Ntando");
        assertEquals(greet.greetPerson(), "Molo Ntando!");
    }
    @Test
    public void ShouldGreetAUserInAfrikaansTest() {
        Greet greet = new Greet("Afrikaans", "Ntando");
        assertEquals(greet.greetPerson(), "Goeie dag Ntando!");
    }

}
