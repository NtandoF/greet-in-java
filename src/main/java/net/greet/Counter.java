package net.greet;

public interface Counter {

    public void greeted(String name);
    public int counterForUser(String name);
    public int counter();
    public int clearUser(String name);
    public void clearUsers();
    public void greetedNames();

}
