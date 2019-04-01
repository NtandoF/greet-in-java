package greet;
import java.util.*;
import greet.Greet;

public class Greeted extends Greet {
    HashMap<Integer, String> greetedUsers = new HashMap<Integer, String>();

    public void greetCounter(String name) {

        if (greetedUsers.containsKey(name)) {
            greetedUsers.put(Integer.valueOf(greetedUsers.get(name) + 1), name);
        }
        else(){
            greetedUsers
        }
    }

}


