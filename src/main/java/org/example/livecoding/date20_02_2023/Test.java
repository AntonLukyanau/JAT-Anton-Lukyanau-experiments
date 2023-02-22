package org.example.livecoding.date20_02_2023;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {
    public static void readFile(File file) {
        try {
            read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void read(File file) throws IOException {
        RandomAccessFile input = null;
        try {
            input = new RandomAccessFile(file, "r");
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}
