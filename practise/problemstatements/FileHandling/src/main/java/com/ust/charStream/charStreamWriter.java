package com.ust.charStream;

import java.io.*;

public class charStreamWriter {
    public static void main(String[] args) {
        try {
            Writer output=new FileWriter("data.txt");
            BufferedWriter writer=new BufferedWriter(output);

            writer.write("Hi ALl this is Santhosh");
            writer.close();
//            writer.lines().forEach(System.out::println);
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
