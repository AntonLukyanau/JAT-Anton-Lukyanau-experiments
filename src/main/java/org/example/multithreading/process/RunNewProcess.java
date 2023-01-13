package org.example.multithreading.process;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 Задача: Создайте новый текстовый файл с каким-нибудь текстом. Затем создайте новый процесс, который откроет этот файл.
 Затем завершите этот процесс и очистите/удалите файл.
 */
public class RunNewProcess {
    public static void main(String[] args) {
        try {
            try (FileWriter fileWriter = new FileWriter("test.txt")) {
                fileWriter.write("Hello from Java! " + LocalDateTime.now());
            }
            Process notepadProcess = Runtime.getRuntime().exec("notepad test.txt");
            Thread.sleep(8000);
            notepadProcess.destroy();
            try (FileWriter fileWriter = new FileWriter("test.txt")) {
                fileWriter.write("");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
