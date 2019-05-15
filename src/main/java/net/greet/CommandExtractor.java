package net.greet;

public class CommandExtractor {

    private final String[] commandParts;
    private String name;
    private String command;
    private String lang;


    public CommandExtractor(String command) {
        this.commandParts = command.split(" ");
        this.lang = "xhosa";
        if (commandParts.length == 3) {
            this.lang=commandParts[2];
        }

        this.command = commandParts [0];

        if (commandParts.length >= 2){
            this.name=commandParts[1];
        } else {
            this.name = "";
        }
    }

    public boolean containName(){
        return !name.isEmpty();
    }

    public String getLang() {

        return lang;
    }

        public String getName(){

        return name;
    }

    public String greetPerson(){
        return LanguageType.valueOf(lang).getlanguage() + " " + getName();

    }

    public String getCommand() {
        return command;
    }
}
