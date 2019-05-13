package net.greet;

public class Greet {

    private String language;
    private String name;

    public Greet(String language, String name) {
        this.name = name.toLowerCase();
        this.language = language;

    }

    public String greetPerson() {
        return LanguageType.valueOf(language).getLang(name);

    }

 }











