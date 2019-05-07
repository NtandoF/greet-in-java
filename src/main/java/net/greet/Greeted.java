package net.greet;

import java.util.Map;

public interface Greeted {

     void greeted(String name);
     int counterForUser(String name);
     int counter();
     void clearUser(String name);
     void clearUsers();
     Map<String, Integer> greetedNames();
     String help();
     void exit();

}
