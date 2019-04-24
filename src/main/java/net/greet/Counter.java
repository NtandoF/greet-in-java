package net.greet;

import java.util.Map;

public interface Counter {

     void greeted(String name);
     int counterForUser(String name);
     int counter();
     void clearUser(String name);
     void clearUsers();
     Map<String, Integer> greetedNames();
     void help();
     void exit();

}
