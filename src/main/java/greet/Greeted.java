package greet;
import java.util.*;
import greet.Greet;

public class Greeted {

    public static void main(String args[])
    {
        Map< String,Integer> hm = new HashMap< String,Integer>();
        hm.put("name", new Integer(1));

        Set< Map.Entry< String,Integer> > st = hm.entrySet();

        for (Map.Entry< String,Integer> me:st)
        {
            System.out.print(me.getKey()+":");
            System.out.println(me.getValue());
        }
    }
}
