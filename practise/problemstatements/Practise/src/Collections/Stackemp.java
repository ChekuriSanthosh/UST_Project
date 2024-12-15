package Collections;

import java.util.Stack;

public class Stackemp {
    public static void main(String[] args) {
        Stack<Integer> res=new Stack<>();

        res.push(10);
        res.push(20);
        res.push(30);
        res.push(40);

        System.out.println(res.peek());
        while (!res.isEmpty()){
            int item=res.peek();
            System.out.println(item);
            res.remove((Object)item);
        }
    }
}
