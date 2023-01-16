package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class menu_option_remove {
    public static void main(String[] args) {

    }

    public void removeFromFile() {
        Path path = Paths.get("TaskManager/tasks.csv");
        try {
            if (Files.notExists(path)) {
                Files.createFile(path);
                System.out.println(ConsoleColors.PURPLE_BOLD + "File didn't exist. New file has been created\n" + ConsoleColors.RESET);
            }
            List<String> lines = Files.readAllLines(path);
            StringBuilder sb = new StringBuilder();
            for (String line : lines) {
                sb.append(line).append("\n");
            }
            String[] taskArray = sb.toString().split("\n");

            Scanner scanner = new Scanner(System.in);

            System.out.println(ConsoleColors.BLUE + "\nHere you can REMOVE tasks from the List" + ConsoleColors.RESET);
            System.out.println("Type " + ConsoleColors.BLUE + "remove" + ConsoleColors.RESET + " to remove task or " + ConsoleColors.BLUE + "exit" + ConsoleColors.RESET + " to return to Main Menu.");
            System.out.print("I want to: ➤ ");

            boolean shouldContinue = true;
            while (shouldContinue) {
                String line = scanner.nextLine();
                switch (line) {
                    case "exit":
                        shouldContinue = false;
                        System.out.println("");
                        break;
                    case "remove":
                        menu_option_list menu_option_list = new menu_option_list();
                        menu_option_list.list();

                        System.out.print(ConsoleColors.BLUE + "Which task do you want to delete?" + ConsoleColors.RESET + "\nTask number: ➤ ");
                        Scanner taskNumber = new Scanner(System.in);

                        boolean isTaskNumeric = true;
                        int index = 0;
                        while (isTaskNumeric) {
                            String task = taskNumber.nextLine();
                            if (isNumeric(task)) {
                                int i = Integer.parseInt(task);
                                if (i > 0 && i < taskArray.length + 1) {
                                    index = Integer.parseInt(task);
                                    isTaskNumeric = false;
                                } else {
                                    System.out.print(ConsoleColors.PURPLE_BOLD + "Has to be a number between 1 and " + (taskArray.length) + ConsoleColors.RESET + "\nType line number: ➤ ");
                                }
                            } else {
                                System.out.print(ConsoleColors.PURPLE_BOLD + "Has to be a proper number" + ConsoleColors.RESET + "\nType line number: ➤ ");
                            }
                        }

                        System.out.print(ConsoleColors.PURPLE_BOLD + "\nKASUJEMY: " + ConsoleColors.RESET + taskArray[index-1] +
                                "\n\nType " + ConsoleColors.BLUE + "remove" + ConsoleColors.RESET + " to remove another task, or " + ConsoleColors.BLUE + "exit" + ConsoleColors.RESET + " to exit to Main Menu:\n➤ ");
                        break;

                    default:
                        System.out.println("Chose " + ConsoleColors.PURPLE_BOLD + "remove" + ConsoleColors.RESET
                                + " or " + ConsoleColors.PURPLE_BOLD + "exit" + ConsoleColors.RESET + " option only.");
                        System.out.print("I want to: ➤ ");
                        break;
                }
            }

        } catch (IOException e) {
            System.err.println("Błąd zapisu/odczytu: " + e.getMessage());
        }

    }

    public static boolean isNumeric(String task) {
        if (task == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(task);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}

