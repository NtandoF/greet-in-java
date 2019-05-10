package net.greet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommandProcessorTest {

    Greeted greetedMock = mock(Greeted.class);

    CommandProcessor comm = new CommandProcessor(greetedMock);

    @Nested
    @DisplayName("when greet command is executed")
    class shouldGreetPerson {

        @Test
        @DisplayName("greet someone in Afrikaan")
        void greetInAfrikaans() {
            CommandExtractor commandExtractor = new CommandExtractor("greet thabang afrikaans");

            assertEquals("Goeie dag thabang", comm.main(commandExtractor));
        }

        @Test
        @DisplayName("greet someone in default language")
        void greetInDefaultLanguage() {
            CommandExtractor commandExtractor = new CommandExtractor("greet thabang");

            assertEquals(comm.main(commandExtractor), "Molo thabang");
        }

        @Test
        @DisplayName("greeted")
        void shouldReturnAMapOfAllUsersGreeted() {
            Map<String, Integer> map = new HashMap<>();
            map.put("thabang", 5);
            map.put("ntando", 2);

            when(greetedMock.greetedNames()).thenReturn(map);

            CommandExtractor commandExtractor = new CommandExtractor("greeted");

            assertEquals(comm.main(commandExtractor), "{thabang=5, ntando=2}");
            verify(greetedMock).greetedNames();
        }

        @Test
        @DisplayName("greeted")
        void shouldCountHowManyTimesHasOneUserBeenGreeted() {

            Map<String, Integer> map = new HashMap<>();
            map.put("thabang", 5);

            when(greetedMock.greetedNames()).thenReturn(map);

            CommandExtractor commandExtractor = new CommandExtractor("greeted thabang");

            assertEquals(comm.main(commandExtractor), "{thabang=5}");

        }

        @Test
        @DisplayName("counter")
        void shouldReturntheCorrectNumberOfUsers() {

            when(greetedMock.counter()).thenReturn(3);

            CommandExtractor commandExtractor = new CommandExtractor("counter");

            assertEquals(comm.main(commandExtractor), "3");
            verify(greetedMock).counter();

        }
        @Test
        @DisplayName("clear")
        void shouldClearAllUsers() {

            when(greetedMock.clearUsers()).thenReturn("Users was deleted :-)");
            CommandExtractor commandExtractor = new CommandExtractor("clearUsers");

            assertEquals(comm.main(commandExtractor), "Users was deleted :-)");
            verify(greetedMock).clearUsers();

        }
        @Test
        @DisplayName("clearUser")
        void shouldClearOneUser() {
            Map<String, Integer> map = new HashMap<>();
            map.put("thabang", 5);
            map.put("lunga", 5);
            map.put("prince", 5);

            when(greetedMock.clearUser("thabang")).thenReturn("User deleted :-)");

            CommandExtractor commandExtractor = new CommandExtractor("clearUser thabang");

            assertEquals(comm.main(commandExtractor), "User deleted :-)");
        }
    }
}