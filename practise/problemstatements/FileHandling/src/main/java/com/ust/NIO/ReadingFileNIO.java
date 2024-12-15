package com.ust.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFileNIO {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("data.txt")).forEach(System.out::println);
    }
}
