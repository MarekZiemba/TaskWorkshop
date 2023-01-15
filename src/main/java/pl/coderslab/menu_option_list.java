package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class menu_option_list {
    public static void main(String[] args) {

    }

    public void list () {
        System.out.println(ConsoleColors.GREEN_BOLD + "\n    \"TO DO\" list:" + ConsoleColors.RESET);
        File file = new File("TaskManager/tasks.csv");
        StringBuilder reading = new StringBuilder();
        try {
            Scanner scan = new Scanner(file);
            int lineNumber = 1;
            while (scan.hasNextLine()) {
                reading.append(ConsoleColors.GREEN_BOLD + lineNumber + ConsoleColors.RESET + " : " + scan.nextLine() + "\n");
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku.");
        }
        System.out.println(reading.toString());


    }



}
