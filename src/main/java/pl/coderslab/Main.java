package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String [] mainMenu = {"add", "remove", "list", "exit"};
        Scanner scanner = new Scanner(System.in);

        boolean shouldContinue = true;

        while (shouldContinue) {
            main_menu_list main_menu_list = new main_menu_list();
            main_menu_list.list();
            String input = scanner.nextLine();
            switch (input) {
                case "add":
                    menu_option_add menu_option_add = new menu_option_add();
                    menu_option_add.writeToFile();
                    break;
                case "remove":
                    System.out.println("OPCJA REMOVE - Work in progress");
                    break;
                case "list":
                    menu_option_list menu_option_list = new menu_option_list();
                    menu_option_list.list();
                    break;
                case "exit":
                    System.out.println("\n " + ConsoleColors.WHITE_BRIGHT + "Don't forget to do the tasks!"+ ConsoleColors.RESET + "\n See you next time!");
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Please select a " + ConsoleColors.PURPLE_BOLD + "correct" + ConsoleColors.RESET + " option.\n");
            }
        }

    }
}