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

    public void counter(){
        System.out.println(count= greetedUsers.size());
       // return count = greetedUsers.size();
    }


    public int clearUser(String name){
        return greetedUsers.remove(name);
    }

    public void clearUsers(){
       greetedUsers.clear();
    }
    public void greetedNames(){
        System.out.println(greetedUsers);
    }
}


