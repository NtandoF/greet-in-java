package net.greet;

import org.junit.jupiter.api.Test;

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
        greeted.greeted("Leyo");
        greeted.greeted("Leyo");
        greeted.greeted("Leyo");
        greeted.greeted("Leyo");
        greeted.greeted("Ntando");

        assertEquals(greeted.counter(), 2);
        greeted.clearUser("Leyo");
        assertEquals(greeted.counter(), 1);

    }

    @Test
    public void shouldRemoveAllUsers() {

        Greeted greeted = new Greeted();
        greeted.greeted("tido");
        greeted.greeted("tido");
        greeted.greeted("tido");
        greeted.greeted("Thabang");
        greeted.greeted("Ntando");

        assertEquals(greeted.counter(), 3);
        greeted.clearUsers();
        assertEquals(greeted.counter(), 0);

    }
}


