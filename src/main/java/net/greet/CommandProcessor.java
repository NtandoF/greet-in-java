package net.greet;

public class CommandProcessor {

    CommandExtractor commandExtractor;
    //    String [] index;
//    Greet greet; GreetedUsingJDBC greeted;
    Greeted greeted;
//

    CommandProcessor(Greeted greeter) {
        this.greeted = greeter;
    }

    public String main(CommandExtractor commandExtractor) {
        if (("greet").equals(commandExtractor.getCommand())) {
            return commandExtractor.greetPerson();
        } else if (("greeted").equals(commandExtractor.getCommand())) {
            if (commandExtractor.getName().isEmpty()) {
                return greeted.greetedNames().toString();
            }
        } else if (("greeted").equals(commandExtractor.getCommand())) {
            if (commandExtractor.getName().isEmpty()) {
                return String.valueOf(greeted.counterForUser(commandExtractor.getName()));

            } else if (("counter").equals(commandExtractor.getCommand())) {
                return String.valueOf(greeted.counter());

            } else if (("clearUsers").equals(commandExtractor.getCommand())) {
                greeted.clearUsers();
                return "0";

            } else if (("clearUser").equals(commandExtractor.getCommand())) {
                greeted.clearUser("");
                return "0";

            } else if (("exit").equals(commandExtractor.getCommand())) {
                greeted.exit();
                return "0";
            } else if (("help").equals(commandExtractor.getCommand())) {

                return greeted.help();
            }

//        else {
            return "Invalid";
//        }

        }
        return "Invalid";
    }
}



//    public void getCommand(){
//
//        if (index[0].equalsIgnoreCase("greet") && index.length == 2) {
//            String user = index[1];
//            inner.greeted(user);
//            String language = "xhosa";
//            System.out.println(LanguageType.valueOf(language).getLang(" " + user));
//        }
//
//        else if (index[0].equalsIgnoreCase("greet") && index.length == 3) {
//            String user = index[1];
//            inner.greeted(user);
//            String language = index[2];
//            System.out.println(LanguageType.valueOf(language).getLang(" " + user));
//        }
//        else if (index[0].equalsIgnoreCase("counter") && index.length == 1) {
//            inner.counter();
//            System.out.println(inner.counter()+ " " + "Users have been greeted");
//
//        }
//        else if (index[0].equalsIgnoreCase("greeted") && index.length == 1) {
//            inner.greetedNames();
//        }
//        else if (index[0].equalsIgnoreCase("greeted") && index.length == 2) {
//
//            System.out.println(index[1] + " have been greeted " + inner.counterForUser(index[1]));
//        }
//        else if (index[0].equalsIgnoreCase("clear") && index.length == 1) {
//            inner.clearUsers();
//        }
//        else if (index[0].equalsIgnoreCase("clearUser") && index.length == 2) {
//            inner.clearUser(index[1]);
//        }
//        else if (index[0].equalsIgnoreCase("help") && index.length == 1) {
//            inner.help();
//        }
//        else if (index[0].equalsIgnoreCase("exit") && index.length == 1) {
//            inner.exit();
//        }
//
//        else {
//            System.out.println("Enter help to view valid commands!");
//        }
//    }


