package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CommandExtractorTest {
    Greeted greetedMock = mock(Greeted.class);

    CommandProcessor comm = new CommandProcessor(greetedMock);


    @Test
    void getLang() {
        CommandExtractor commandExtractor = new CommandExtractor("greet aya afrikaans");
        assertEquals(commandExtractor.getLang(), "afrikaans");
    }

    @Test
    void getName() {
        CommandExtractor commandExtractor = new CommandExtractor("greet ntando xhosa");
        assertEquals(commandExtractor.getName(), "ntando");

    }

    @Test
    void greetPerson() {
        CommandExtractor commandExtractor = new CommandExtractor("greet thabang afrikaans");
        assertEquals(commandExtractor.getCommand(), "greet");
        assertEquals(commandExtractor.getName(), "thabang");
        assertEquals(commandExtractor.getLang(), "afrikaans");
    }

    @Test
    void getCommand() {
        CommandExtractor commandExtractor = new CommandExtractor("greeted xola");
        assertEquals(commandExtractor.getCommand(), "greeted");

    }
}