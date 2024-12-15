package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class Calculator<T>{
    private T value;

    public Calculator(T value) {
        this.value = value;
    }

    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value=value;
    }
    public T doubleValue(){
        if(value instanceof Integer n){
            return (T)Integer.valueOf(n*2);
        }else if(value instanceof String s){
            return (T)String.valueOf(s+s);
        }else {
            return value;
        }

//        return switch (value){
//            case Integer i->(T)Integer.valueOf(i*2);
//            case String s->(T)(s+s);
//            default -> value;
//        };
    }
}

public class Generics {
    public static void main(String[] args) {
        Calculator<? super Integer> calc=new Calculator<>("Hello");
        System.out.println(calc.doubleValue());
//        list <String>arr=new ArrayList<String>(List.of("san","savvv"));
//
//        List.for
        Vector<String> res=new Vector<>();

    }
}
