package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class menu_option_add {
    public static void main(String[] args) {

    }

        public  void writeToFile() {
            Path path = Paths.get("TaskManager/tasks.csv");
            try {
                if (Files.notExists(path)) {
                    Files.createFile(path);
                }
                List<String> lines = Files.readAllLines(path);
                StringBuilder sb = new StringBuilder();
                for (String line : lines) {
                    sb.append(line).append("\n");
                }

                Scanner scanner = new Scanner(System.in);

                System.out.println(ConsoleColors.BLUE + "Here you can ADD new tasks to the List" + ConsoleColors.RESET);
                System.out.println("Type: new to \"add\", or \"exit\" to return to Main Menu");
                System.out.print("I want to: ➤ ");

                boolean shouldContinue = true;
//                String [] tasks;
                while (shouldContinue) {
                    String line = scanner.nextLine();
                    switch (line) {
                        case "exit":
                            shouldContinue = false;
                            break;
                        case "add":
                            System.out.println("Please add task description");
                            line = scanner.nextLine();
                            sb.append(line).append(" "); //zbierammy w SB
                            System.out.println("Please add task due time: yyyy-mm-dd");
                            line = scanner.nextLine();
                            sb.append(line).append(" "); //zbierammy w SB
                            System.out.println("Is the task important: true/false");
                            line = scanner.nextLine();
                            sb.append(line).append("\n"); //zbierammy w SB
                            System.out.print("I want to: ➤ ");
                            break;

                        default:
                            System.out.println("Chose " + ConsoleColors.PURPLE_BOLD + "add" + ConsoleColors.RESET
                                    + " or " + ConsoleColors.PURPLE_BOLD + "exit" + ConsoleColors.RESET + " option only.");
                            System.out.print("I want to: ➤ ");
                            break;
                    }
                }


                Files.writeString(path, sb);  //zapis (nadpisuje plik)
            } catch (IOException e) {
                System.err.println("Błąd zapisu/odczytu: " + e.getMessage());
            }
        }

}
