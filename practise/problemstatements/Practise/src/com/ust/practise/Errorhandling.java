package com.ust.practise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Errorhandling {

    public static int getage() throws Invalidageexception{
        int age;
        System.out.println("Input your age: ");
        age=new Scanner(System.in).nextInt();
        if(age<=0 || age>100){
            throw new Invalidageexception("Sorry Invalid Age");
        }
        return age;
    }
    public static void main(String[] args) {

        try {
            int age=getage();
            System.out.println("Age is :"+age);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
