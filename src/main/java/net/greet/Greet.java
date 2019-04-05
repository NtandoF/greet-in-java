package net.greet;

import java.util.Scanner;

public class Greet {

    private String language;
    private String name;

    public Greet(String language, String name) {
        this.name = name;
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

        while (true) {

            Scanner input = new Scanner(System.in);
            System.out.println("");
            System.out.println("**************************************");
            System.out.println("Please enter your name :");
            String name = input.next();
            System.out.println("");
            System.out.println("Please enter lang :");
            String language = input.next();
            System.out.println("");
            System.out.println(LanguageType.valueOf(language).getLang(" " + name));
//
//            if (!"exit".equals(name)){
//                break;
//            }

         }
      }

    }











