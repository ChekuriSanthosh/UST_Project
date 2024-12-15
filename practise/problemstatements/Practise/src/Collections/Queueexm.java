package Collections;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queueexm {
    public static void main(String[] args) {
        Queue<String> res= new LinkedList<>();

        res.offer("Santhosh");
        res.offer("Pranith");
        res.offer("Kodi");
        res.offer("Loki");

        while (!res.isEmpty()){
            String san=res.peek();
            System.out.println(san);
            res.remove(san);
        }

        System.out.println();
        Queue<String> res1=new ArrayDeque<>();
        res1.offer("Santhosh");
        res1.offer("Pranith");
        res1.offer("Kodi");
        res1.offer("Loki");
        while (!res1.isEmpty()){
            String san=res1.peek();
            System.out.println(san);
            res1.remove(san);
        }
        System.out.println();
        Queue<String> res2=new PriorityQueue<>();
        res2.offer("Santhosh");
        res2.offer("Pranith");
        res2.offer("Kodi");
        res2.offer("Loki");
        while (!res2.isEmpty()){
            String san=res2.peek();
            System.out.println(san);
            res2.remove(san);
        }

    }
}
