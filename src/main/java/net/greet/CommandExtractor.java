package net.greet;

public class CommandExtractor {

    private final String[] commandParts;
    private String name;
//    String [] commandParts;
    private String command;
    public String lang;


    public CommandExtractor(String command) {
        this.commandParts = command.split(" ");
        this.name = "";
        this.lang = "xhosa";
        if (commandParts.length == 3) {
            this.lang=commandParts[2];
        }
        this.command = commandParts [0];

    }

    public String getLang() {

        return LanguageType.valueOf(lang).getlanguage();
    }

        public String getName(){
        if (commandParts.length >= 2){
            return commandParts[1];
        }
        return name = "";
    }

    public String greetPerson(){
        return getLang() + " " + getName();

    }

    public String getCommand() {
        return command;
    }
}
