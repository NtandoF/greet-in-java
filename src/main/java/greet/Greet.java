package greet;

    public class Greet {

        private final LanguageType language;
        private final String name;

    public Greet (LanguageType language, String name){
        this.name = name;
        this.language = language;

    }

    public String greetPerson () {

        if (language == LanguageType.English) {
            return "Hello, " + name;
        }
        if (language == LanguageType.Xhosa) {
            return "Molo, " + name;
        }
        if (language == LanguageType.Afrikaans) {
            return "Hallo, " + name;
        }
        else {
            return "Please enter a langauage and name";
        }

    }


}









