package net.greet;

public class CommandProcessor {

    CommandExtractor commandExtractor;
    Greeted greeted;

    CommandProcessor(Greeted greeter) {
        this.greeted = greeter;
    }

    public String main(CommandExtractor commandExtractor) {
        if (("greet").equals(commandExtractor.getCommand())) {
            greeted.greeted(commandExtractor.getName());
            return commandExtractor.greetPerson();
        } else if (("greeted").equals(commandExtractor.getCommand())) {
            if (commandExtractor.containName()) {
                return String.valueOf(greeted.counterForUser(commandExtractor.getName()));
            }
            return greeted.greetedNames().toString();

        } else if (("counter").equals(commandExtractor.getCommand())) {
            return String.valueOf(greeted.counter());

        } else if (("clearUsers").equals(commandExtractor.getCommand())) {
            return greeted.clearUsers();

        } else if (("clearUser").equals(commandExtractor.getCommand())) {
            return greeted.clearUser(commandExtractor.getName());

        } else if (("exit").equals(commandExtractor.getCommand())) {
            greeted.exit();
            return "0";
        } else if (("help").equals(commandExtractor.getCommand())) {
            return greeted.help();
        } else {
            return "Please enter a valid command type help for more info";
        }
    }

}



