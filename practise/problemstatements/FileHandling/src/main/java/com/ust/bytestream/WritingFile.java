package com.ust.bytestream;

import java.io.*;
import java.util.Scanner;

public class WritingFile {
    public static void main(String[] args) {
        Writer output=null;
        try {
            output=new FileWriter("data.txt",true);
            String lines= """
                   Hello all,
                   we are writing data on a file
                    """;
            output.write(lines);

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                output.close();
            }
            catch (IOException ex){
                System.err.println(ex.getMessage());
            }
        }
    }
}
