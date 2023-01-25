package pl.coderslab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean shouldContinue = true;

        while (shouldContinue) {
            mainMenuList mainMenuList = new mainMenuList();
            mainMenuList.list();
            String input = scanner.nextLine();
            switch (input) {
                case "add":
                    MenuOptionAdd menuOptionAdd = new MenuOptionAdd();
                    menuOptionAdd.writeToFile();
                    break;
                case "remove":
                    MenuOptionRemove menuOptionRemove = new MenuOptionRemove();
                    menuOptionRemove.removeFromFile();
                    break;
                case "list":
                    MenuOptionList menuOptionList = new MenuOptionList();
                    menuOptionList.list();
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
