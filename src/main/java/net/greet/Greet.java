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


//        if (language == "xhosa") {
//            return String.format("Molo %s!", name);
//        }
//        else if (language == "afrikaans") {
//            return String.format("Goeie dag %s!", name);
//        }
//        else if (language == "english") {
//            return String.format("Hello %s!", name);
//        } else {
//
//            return String.format("Type your name %s!!!", name.toUpperCase() + " with a language!");
//        }
    }

 }











