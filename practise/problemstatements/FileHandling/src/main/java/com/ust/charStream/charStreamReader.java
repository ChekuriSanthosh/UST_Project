package com.ust.charStream;

import java.io.*;

public class charStreamReader {
    public static void main(String[] args) {
        try {
            Reader input=new FileReader("data.txt");
            BufferedReader reader=new BufferedReader(input);

            reader.lines().forEach(System.out::println);
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
