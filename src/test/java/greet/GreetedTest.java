package greet;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GreetedTest {

    @Test
   public void shouldReturnTheCorrectNumOfUsersGreeted() {

            Greeted greeted = new Greeted();
            greeted.greeted("tido");
            greeted.greeted("Thabang");
            greeted.greeted("Ntando");
            greeted.greeted("Zuma");

            assertEquals(greeted.counter(), 4);
            }

    @Test
    public void shouldReturnTheCorrectNumForOneUserGreeted() {

        Greeted greeted = new Greeted();
        greeted.greeted("tido");
        greeted.greeted("tido");
        greeted.greeted("tido");
        greeted.greeted("Thabang");
        greeted.greeted("Ntando");


        assertEquals(greeted.counterForUser("tido"), 3);
    }

    @Test
    public void shouldRemoveOneUser() {

        Greeted greeted = new Greeted();
        greeted.greeted("tido");
        greeted.greeted("tido");
        greeted.greeted("tido");
        greeted.greeted("Thabang");
        greeted.greeted("Ntando");


        assertEquals(greeted.clearUser("tido"), 3);
    }



}
