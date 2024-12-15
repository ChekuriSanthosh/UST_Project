package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
    Calculator calci = new Calculator();
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);

    int sum = a + b;
            System.out.println(sum);
}
}
