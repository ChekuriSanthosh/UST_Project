package Collections;

import java.util.Map;

interface Printer{
    void print();
    default void scan(){
        System.out.println("Scanning printer1");
    }
}

interface Printer2{
    void print();
//    default void scan(){
//        System.out.println("scanning printer2");
//    }
}

class BasicPrint implements Printer,Printer2{
    public void print(){
        System.out.println("Basic printing");
    }

}

public class defaultandstaticexam {
    public static void main(String[] args) {
        Printer p=new BasicPrint();
        p.print();
        p.scan();
    }
}
