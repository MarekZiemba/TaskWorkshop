package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class menu_option_add {
    public static void main(String[] args) {

    }

        public  void writeToFile() {
            Path path = Paths.get("TaskManager/tasks.csv");
            System.out.println("Podaj dane. Napisz \"quit\" żeby wyjść");
            try {
                if (Files.notExists(path)) {
                    Files.createFile(path);
                }
                StringBuilder sb = new StringBuilder();

                Scanner scanner = new Scanner(System.in);
                String line;

                while (true) {
                    line = scanner.nextLine();
                    if ("quit".equals(line)) {
                        break;
                    } else {
                        sb.append(line).append("\n"); //zbierammy w SB
                    }
                }

                Files.writeString(path, sb);  //zapis (nadpisuje plik)
            } catch (IOException e) {
                System.err.println("Błąd zapisu/odczytu: " + e.getMessage());
            }
        }

}
