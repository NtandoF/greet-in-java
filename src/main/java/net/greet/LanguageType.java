package net.greet;

public enum LanguageType {
    english("Hello"),
    xhosa("Molo"),
    afrikaans("Goeie dag");


    private final String lang;

    LanguageType(String expression) {
        this.lang = expression;
    }

    public String getLang(String name) {
        return this.lang + " " + name;
    }

    public String getlanguage(){
        return this.lang;
    }

}

