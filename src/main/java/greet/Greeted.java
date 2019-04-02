package greet;
import java.util.*;

public class Greeted extends Greet {
    HashMap<String, Integer> greetedUsers=new HashMap<String, Integer>();

    public void greeted(String name) {

        if (greetedUsers.containsKey(name)) {
            greetedUsers.put(name, greetedUsers.get(name) + 1);

        }
        else {
            greetedUsers.put(name, 1);
        }
    }

    public int counter(){
      return greetedUsers.size();
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

    public int clearUser(String name){
        return greetedUsers.remove(name);
    }

    public int clearUsers(){
        return greetedUsers.clear();
    }


}


