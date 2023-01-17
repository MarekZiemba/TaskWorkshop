package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static pl.coderslab.menu_option_remove.count;

public class menu_option_list {
    public static void main(String[] args) {

    }

    public void list () {
        System.out.println(ConsoleColors.GREEN_BOLD + "\n        \"TO DO\" list:" + ConsoleColors.RESET);
        File file = new File("TaskManager/tasks.csv");
        StringBuilder reading = new StringBuilder();
        try {
            if (count("TaskManager/tasks.csv") < 1) {
                System.out.println(ConsoleColors.RED_BOLD + "\nThe List is empty." + ConsoleColors.RESET + " Rejoice! There's nothing to do.");
                } else {
                System.out.println(ConsoleColors.GREEN + "Description" + ConsoleColors.RESET + " | " + ConsoleColors.GREEN + "Due date"
                        + ConsoleColors.RESET + " | " + ConsoleColors.GREEN + "Is important?" + ConsoleColors.RESET);
                Scanner scan = new Scanner(file);
                int lineNumber = 1;
                while (scan.hasNextLine()) {
                    reading.append(ConsoleColors.GREEN_BOLD + lineNumber + ConsoleColors.RESET + " : " + scan.nextLine() + "\n");
                    lineNumber++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist." + e.getMessage());
        }
        System.out.println(reading.toString());
    }

}
