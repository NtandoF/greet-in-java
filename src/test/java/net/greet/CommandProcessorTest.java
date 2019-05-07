package net.greet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
            CommandExtractor commandExtractor = new CommandExtractor("greeted");

            assertEquals(comm.main(commandExtractor), "{}");
            verify(greetedMock).greetedNames();
        }

        @Test
        @DisplayName("greeted")
        void shouldCountHowManyTimesHasOneUserBeenGreeted() {
            when(greetedMock.counterForUser("jan")).thenReturn(1);
            CommandExtractor commandExtractor = new CommandExtractor("greeted jan");

            assertEquals(comm.main(commandExtractor), "{}");
            verify(greetedMock.counterForUser("jan"));
        }

        @Test
        @DisplayName("counter")
        void shouldReturntheCorrectNumberOfUsers() {

            when(greetedMock.counter()).thenReturn(1);

            CommandExtractor commandExtractor = new CommandExtractor("counter");

            assertEquals(comm.main(commandExtractor), "1");
            verify(greetedMock).counter();

        }
        @Test
        @DisplayName("clear")
        void shouldClearAllUsers() {
            CommandExtractor commandExtractor = new CommandExtractor("clearUsers");

            assertEquals(comm.main(commandExtractor), "0");
        }
        @Test
        @DisplayName("clearUser")
        void shouldClearOneUser() {
            CommandExtractor commandExtractor = new CommandExtractor("clearUser");

            assertEquals(comm.main(commandExtractor), "0");
        }
    }
}