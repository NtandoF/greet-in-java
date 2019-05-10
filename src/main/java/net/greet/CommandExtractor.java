package net.greet;

public class CommandExtractor {

    private final String[] commandParts;
    private String name;
//    String [] commandParts;
    private String command;
    public String lang;


    public CommandExtractor(String command) {
        this.commandParts = command.split(" ");
        this.lang = "xhosa";
        if (commandParts.length == 3) {
            this.lang=commandParts[2];
        }

        this.command = commandParts [0];

        if (commandParts.length >= 2){
            this.name=commandParts[1];
        }
    }

    public String getLang() {

        return LanguageType.valueOf(lang).getlanguage();
    }

        public String getName(){

        return name;
    }

    public String greetPerson(){
        return getLang() + " " + getName();

    }

    public String getCommand() {
        return command;
    }
}
