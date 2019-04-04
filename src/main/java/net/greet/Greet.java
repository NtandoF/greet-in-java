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
        Scanner input = new Scanner(System.in);
        System.out.println("Hello please enter your name");
        String name = input.next();
        Greet message = new Greet("English", name);
        Greeted counter = new Greeted();


        message.greetPerson();
        counter.greeted(name);
        counter.counter();


        System.out.println( message.greetPerson());
        System.out.println( counter.counterForUser(name));


    }

}









