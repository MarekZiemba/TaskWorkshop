package pl.coderslab;

import org.apache.commons.validator.GenericValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class menu_option_add {
    public static void main(String[] args) {

    }

        public void writeToFile() {
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

                System.out.println(ConsoleColors.BLUE + "\nHere you can ADD new tasks to the List" + ConsoleColors.RESET);
                System.out.println("Type " + ConsoleColors.BLUE + "add" + ConsoleColors.RESET + " to add new task, or " + ConsoleColors.BLUE + "exit" + ConsoleColors.RESET + " to return to Main Menu.");
                System.out.print("I want to: ➤ ");

                boolean shouldContinue = true;
                while (shouldContinue) {
                    String line = scanner.nextLine();
                    switch (line) {
                        case "exit":
                            shouldContinue = false;
                            System.out.println("");
                            break;
                        case "add":
                            System.out.print("Please add task description: \n➤ ");
                            line = scanner.nextLine();
                            sb.append(line).append(" "); //zbieramy w SB

                            boolean assertDate = false;
                            int indexDate = 0;
                            while (!assertDate) {
                                if (indexDate == 0) {
                                    indexDate++;
                                    System.out.print("Please add task due time: yyyy-mm-dd \n➤ ");
                                    line = scanner.nextLine();
                                    assertDate = (GenericValidator.isDate(line, "yyyy-MM-dd", true));
                                } else {
                                    System.out.print("Please add task due time: yyyy-mm-dd \nHint: Depending on the month, date should be in range:\n" +
                                            "mm: (01 - 12), dd (01-31) or (01-29) for February.\n➤ ");
                                    line = scanner.nextLine();
                                    assertDate = (GenericValidator.isDate(line, "yyyy-MM-dd", true));
                                }
                            }
                            sb.append(line).append(" "); //zbieramy w SB

                            boolean assertImportance = false;
                            while (!assertImportance) {
                                System.out.print("Is the task important: true/false \n➤ ");
                                line = scanner.nextLine();
                                if (line.equals("true") || line.equals("false")) {
                                    assertImportance = true;
                                }
                            }
                            sb.append(line).append("\n"); //zbieramy w SB

                            System.out.print(ConsoleColors.PURPLE_BOLD + "New entry has been saved" + ConsoleColors.RESET +
                                    "\n\nType " + ConsoleColors.BLUE + "add" + ConsoleColors.RESET + " to add another task, or " + ConsoleColors.BLUE + "exit" + ConsoleColors.RESET + " to exit to Main Menu:\n➤ ");
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
                System.err.println("Input/Output Error: " + e.getMessage());
            }
        }



}
