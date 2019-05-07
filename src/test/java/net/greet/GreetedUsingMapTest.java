package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetedUsingMapTest {

    @Test
    public void shouldReturnTheCorrectNumOfUsersGreeted() {

        GreetedUsingMap greeted = new GreetedUsingMap();
        greeted.greeted("tido");
        greeted.greeted("Thabang");
        greeted.greeted("Ntando");
        greeted.greeted("Zuma");

         assertEquals(greeted.counter(), 4);
    }

    @Test
    public void shouldReturnTheCorrectNumForOneUserGreeted() {

        GreetedUsingMap greeted = new GreetedUsingMap();
        greeted.greeted("tido");
        greeted.greeted("tido");
        greeted.greeted("tido");
        greeted.greeted("Thabang");
        greeted.greeted("Ntando");


        assertEquals(greeted.counterForUser("tido"), 3);
    }

    @Test
    public void shouldRemoveOneUser() {

        GreetedUsingMap greeted = new GreetedUsingMap();
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

        GreetedUsingMap greeted = new GreetedUsingMap();
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


