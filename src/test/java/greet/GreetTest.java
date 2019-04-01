package greet;

import org.junit.jupiter.api.Test;
import greet.LanguageType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

        @Test
      public void ShouldGreetAUserInEnglishTest() {
            Greet greet = new Greet(LanguageType.English, "Ntando");
            assertEquals(greet.greetPerson(), "Hello, Ntando");
        }
    @Test
    public void ShouldGreetAUserInXhosaTest() {
        Greet greet = new Greet(LanguageType.Xhosa, "Ntando");
        assertEquals(greet.greetPerson(), "Molo, Ntando");
    }
    @Test
    public void ShouldGreetAUserInAfrikaansTest() {
        Greet greet = new Greet(LanguageType.Afrikaans, "Ntando");
        assertEquals(greet.greetPerson(), "Hallo, Ntando");
    }
//    @Test
//    public void ShouldReturnWithTheCorrectCounterTest() {
//        Greet greet = new Greet(LanguageType.Afrikaans, "Ntando");
//        assertEquals(greet.getCounter(), 1);
//    }

}
