package net.greet;

import java.sql.SQLException;
import java.util.Scanner;

public class Greet {

    private String language;
    private String name;

    public Greet(String language, String name) {
        this.name = name.toLowerCase();
        this.language = language;

    }

    public String greetPerson() {

        if (language == "Xhosa") {
            return String.format("Molo %s!", name);
        }
        if (language == "Afrikaans") {
            return String.format("Goeie dag %s!", name);
        }
        if (language == "English") {
            return String.format("Hello %s!", name);
        }

        return String.format("Type your name %s!!!", name.toUpperCase() + " with a language!");
    }

    public static void main(String[] args) {
        System.out.println("******Welcome to the greetings app********");

//         Greeted inner = new Greeted();
          Greeted_jdbc inner = new Greeted_jdbc();

        while (true) {

            Scanner input = new Scanner(System.in);
            System.out.println("Enter command :");
            String name = input.nextLine();
            String [] index = name.split(" ");

            if (index[0].equalsIgnoreCase("greet") && index.length == 2) {
                String user = index[1];
                inner.greeted(user);
                String language = "xhosa";
                System.out.println(LanguageType.valueOf(language).getLang(" " + user));
            }

            else if (index[0].equalsIgnoreCase("greet") && index.length == 3) {
                String user = index[1];
                inner.greeted(user);
                String language = index[2];
                System.out.println(LanguageType.valueOf(language).getLang(" " + user));
            }
            else if (index[0].equalsIgnoreCase("counter") && index.length == 1) {
                inner.counter();
                System.out.println(inner.counter()+ " " + "Users have been greeted");

            }
            else if (index[0].equalsIgnoreCase("greeted") && index.length == 1) {
                  inner.greetedNames();
            }
            else if (index[0].equalsIgnoreCase("greeted") && index.length == 2) {

                System.out.println(index[1] + " have been greeted " + inner.counterForUser(index[1]));
            }
            else if (index[0].equalsIgnoreCase("clear") && index.length == 1) {
                inner.clearUsers();
            }
            else if (index[0].equalsIgnoreCase("clearUser") && index.length == 2) {
                inner.clearUser(index[1]);
            }
            else if (index[0].equalsIgnoreCase("help") && index.length == 1) {
               inner.help();
            }
            else if (index[0].equalsIgnoreCase("exit") && index.length == 1) {
                inner.exit();
            }

            else {
                System.out.println("Enter help to view valid commands!");
            }

         }
      }

 }











