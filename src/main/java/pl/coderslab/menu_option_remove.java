package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;
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
            boolean shouldContinue = true;
            boolean lastTask = false;

             if (count("TaskManager/tasks.csv") < 1) {
                 System.out.println(ConsoleColors.RED_BOLD + "\nThe List is empty. Would you like to ADD new tasks?" + ConsoleColors.RESET);
                 menu_option_add menu_option_add = new menu_option_add();
                 menu_option_add.writeToFile();
                 shouldContinue = false;
             }

                    Scanner scanner = new Scanner(System.in);

            while (shouldContinue && !lastTask) {
                System.out.println(ConsoleColors.BLUE + "\nHere you can REMOVE tasks from the List" + ConsoleColors.RESET);
                System.out.println("Type " + ConsoleColors.BLUE + "remove" + ConsoleColors.RESET + " to remove task, or " + ConsoleColors.BLUE + "exit" + ConsoleColors.RESET + " to return to Main Menu.");
                System.out.print("I want to: ➤ ");
                String select = scanner.nextLine();
                switch (select) {
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
                            int index;
                            while (isTaskNumeric) {
                                String task = taskNumber.nextLine();
                                if (isNumeric(task)) {
                                    int i = Integer.parseInt(task);

                                    List<String> lines = Files.readAllLines(path);
                                    StringBuilder sb = new StringBuilder();
                                    for (String line : lines) {
                                        sb.append(line).append("\n");
                                    }
                                    String[] taskArray = sb.toString().split("\n");
                                    String[] newTaskArray;


                                    if (i > 0 && i < taskArray.length + 1) {
                                        if (i == 1 && taskArray.length == 1) { // jesli kasujemy ostatnie zadanie
                                            lastTask = true;
                                            index = Integer.parseInt(task);
                                            isTaskNumeric = false;
                                            System.out.print(ConsoleColors.PURPLE_BOLD + "\nDELETED: " + ConsoleColors.RESET + taskArray[0]);
                                            String emptyList = ("");
                                            Files.writeString(path, emptyList);  //zapis (nadpisuje plik)
                                            System.out.println(ConsoleColors.RED_BOLD + "\nThe List is empty. Would you like to ADD new tasks?" + ConsoleColors.RESET);
                                            menu_option_add menu_option_add = new menu_option_add();
                                            menu_option_add.writeToFile();

                                        } else {
                                            index = Integer.parseInt(task);
                                            isTaskNumeric = false;
                                            System.out.print(ConsoleColors.PURPLE_BOLD + "\nDELETED: " + ConsoleColors.RESET + taskArray[index - 1] +
                                                    "\n\nType " + ConsoleColors.BLUE + "remove" + ConsoleColors.RESET + " to remove another task, or " + ConsoleColors.BLUE + "exit" + ConsoleColors.RESET + " to exit to Main Menu:\n➤ ");
                                            newTaskArray = ArrayUtils.remove(taskArray, index - 1);
                                            Files.writeString(path, convertArrayToString(newTaskArray, "\n"));  //zapis (nadpisuje plik)
                                        }

                                    } else {
                                        System.out.print(ConsoleColors.PURPLE_BOLD + "Has to be a number between 1 and " + (taskArray.length) + ConsoleColors.RESET + "\nType line number: ➤ ");
                                    }
                                } else {
                                    System.out.print(ConsoleColors.PURPLE_BOLD + "Has to be a proper number" + ConsoleColors.RESET + "\nType line number: ➤ ");
                                }
                            }
                            break;

                    default:
                        System.out.println("Chose " + ConsoleColors.PURPLE_BOLD + "remove" + ConsoleColors.RESET
                                + " or " + ConsoleColors.PURPLE_BOLD + "exit" + ConsoleColors.RESET + " option only.");
                        System.out.print("I want to: ➤ ");
                        break;
                }
            }

        } catch (IOException e) {
            System.err.println("Input/Output Error: " + e.getMessage());
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

    public static String convertArrayToString(Object[] arr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : arr)
            sb.append(obj.toString()).append(delimiter);
        return sb.substring(0, sb.length() - 1);
    }

        public static int count(String fileName) {
            File file = new File(fileName);
            StringBuilder sb = new StringBuilder();
            try {
                Scanner scan = new Scanner(file);
                while (scan.hasNextLine()) {
                    sb.append(scan.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File does not exist." + e.getMessage());
            }
            return sb.length();
        }

    }
