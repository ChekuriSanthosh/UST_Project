package com.ust.problem;

import java.io.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        while (true){
            System.out.println("""
                1.Enter text to written in data.txt
                2.Read contents of file
                
                Enter your Choice:
                """);
            Scanner scanner=new Scanner(System.in);
            int res=scanner.nextInt();

            switch (res){
                case 1:
                    Writer output=new FileWriter("data.txt",true);
                    System.out.println("Enter the details to write");
                    Scanner scanner3=new Scanner(System.in);
                    String string=scanner3.nextLine();
                    output.write(string+'\n');
                    output.close();
                    break;
                case 2:
                    InputStream input=new FileInputStream("data.txt");
                    Scanner scanner1=new Scanner(input);
                    while(scanner1.hasNextLine()){
                        String line=scanner1.nextLine();
                        System.out.println(line);
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("choice invalid!! Enter correct choice");
                    break;

            }
        }
    }
}
