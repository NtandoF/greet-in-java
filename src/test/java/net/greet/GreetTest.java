package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

        @Test
      public void ShouldGreetAUserInEnglishTest() {
            Greet greet = new Greet("english", "ntando");
            assertEquals(greet.greetPerson(), "Hello ntando");
        }
    @Test
    public void ShouldGreetAUserInXhosaTest() {
        Greet greet = new Greet("xhosa", "Ntando");
        assertEquals(greet.greetPerson(), "Molo ntando");
    }
    @Test
    public void ShouldGreetAUserInAfrikaansTest() {
        Greet greet = new Greet("afrikaans", "ntando");
        assertEquals(greet.greetPerson(), "Goeie dag ntando");
    }

}
