package net.greet;

public enum LanguageType {
    English("Hello"),
    Xhosa("Molo"),
    Afrikaans("Goeie dag");


    private final String lang;

    LanguageType(String expression) {
        this.lang = expression;
    }

    public String getLang() {
        return this.lang;
    }

}

