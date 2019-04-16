package net.greet;

public interface Counter {

     void greeted(String name);
     int counterForUser(String name);
     int counter();
     int clearUser(String name);
     void clearUsers();
     void greetedNames();

}
