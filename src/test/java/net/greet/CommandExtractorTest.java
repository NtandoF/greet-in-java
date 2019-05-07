package net.greet;

import org.junit.jupiter.api.Test;

import static net.greet.LanguageType.xhosa;
import static org.junit.jupiter.api.Assertions.*;

class CommandExtractorTest {

    @Test
    void getCommand() {

    }

    @Test
    void getlang() {
        CommandExtractor greet = new CommandExtractor("greet ntando");

        assertEquals("Molo ntando", greet.getLang());
    }

    @Test
    void getname() {
    }

    @Test
    void getLength() {
    }
}