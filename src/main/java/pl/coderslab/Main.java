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
                    menuOptionAdd menuOptionAdd = new menuOptionAdd();
                    menuOptionAdd.writeToFile();
                    break;
                case "remove":
                    menuOptionRemove menuOptionRemove = new menuOptionRemove();
                    menuOptionRemove.removeFromFile();
                    break;
                case "list":
                    menuOptionList menuOptionList = new menuOptionList();
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
