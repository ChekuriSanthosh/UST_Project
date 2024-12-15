package stramapi;

import java.util.List;

public class MethodReferencec {
    public static void main(String[] args) {
        var list= List.of(10,20,30,40,50);
        List<String> res= List.of("Santhosh","Loki","Kodi","Pranith");

        res.stream().map(String::toUpperCase).forEach(System.out::println);

//        list.forEach(System.out::println);
    }
}
