package pl.coderslab;

public class main_menu_list {

    public static void main(String[] args) {

    }
        public void list () {
            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
            System.out.println("■          " + ConsoleColors.WHITE_BOLD_BRIGHT + "TASKS" + ConsoleColors.RESET + "           ■");
            System.out.println(ConsoleColors.BLUE + "  Please select an option:" + ConsoleColors.RESET);
            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
            System.out.println("■          ➤ " + ConsoleColors.BLUE + "add" + ConsoleColors.RESET + "           ■\n"
                    + "■          ➤ " + ConsoleColors.BLUE + "remove" + ConsoleColors.RESET + "        ■\n"
                    + "■          ➤ " + ConsoleColors.BLUE + "list" + ConsoleColors.RESET + "          ■\n"
                    + "■          ➤ " + ConsoleColors.BLUE + "exit" + ConsoleColors.RESET + "          ■");
            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
            System.out.print("I want to: ➤ ");

        }



}
