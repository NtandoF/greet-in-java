package net.greet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("******Welcome to the greetings app********");

         Greeted inner = new GreetedUsingJDBC();
//        GreetedUsingJDBC inner = new GreetedUsingJDBC();
        CommandProcessor executer = new CommandProcessor(inner);


        while (true) {

            Scanner input = new Scanner(System.in);
            System.out.println("Enter command :");
            String name = input.nextLine();

            CommandExtractor command  = new CommandExtractor(name);
            executer.main(command);


        }
    }
}
