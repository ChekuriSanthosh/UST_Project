package Collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Treesetemp {
    public static void main(String[] args) {
        Set<String> res= new TreeSet<>();
        res.add("Santhosh");
        res.add("Santhosh");
        res.add("Pranith");
        res.add("Kodi");
        res.add("Loki");
        for (var item:res) {
            System.out.println(item);
        }
        System.out.println(res);
    }
}
