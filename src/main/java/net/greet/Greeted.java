package net.greet;
import java.util.*;

public class Greeted {
    HashMap<String, Integer> greetedUsers=new HashMap<String, Integer>();

    public int count = 0;

    public void greeted(String name) {

        if (greetedUsers.containsKey(name)) {
            greetedUsers.put(name, greetedUsers.get(name) + 1);
            System.out.println(greetedUsers.isEmpty());

        }
        else {
            greetedUsers.put(name, count +1);
        }
    }

    public int counterForUser(String name){
        int counterUser = 0;

        if (greetedUsers.containsKey(name)){
            counterUser = greetedUsers.get(name);
        }

        else {

        }
        return counterUser;
    }

    public int counter(){
        return count = greetedUsers.size();
    }


    public int clearUser(String name){
        return greetedUsers.remove(name);
    }


    public void clearUsers(){
       greetedUsers.clear();
    }

    public void help(){
        System.out.println(" Valid commands that you can use:\n" +
                "        greet followed by your name and prefered language.\n" +
                "        greeted to view all the people greeted.\n" +
                "        counter to view how many people greeted. \n" +
                "        counterUser to view how many times one person as been greeted. \n" +
                "        clearUser to remove one person. \n" +
                "        clearUsers to clear all people entered.");
    }

    public void exit(){
        System.exit(1);
    }


    public void greetedNames(){
        System.out.println(greetedUsers);


    }
}


