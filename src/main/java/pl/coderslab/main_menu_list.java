package pl.coderslab;

public class main_menu_list {

    public static void main(String[] args) {

    }
        public void list () {
            System.out.println(ConsoleColors.BLUE + "Please select an option:" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "■■■■■■■■■■■■■■■■■■■■■■■" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "■" + ConsoleColors.RESET + "         add         " + ConsoleColors.BLUE + "■\n"
                    + "■" + ConsoleColors.RESET + "        remove       " + ConsoleColors.BLUE + "■\n"
                    + "■" + ConsoleColors.RESET + "         list        " + ConsoleColors.BLUE + "■\n"
                    + "■" + ConsoleColors.RESET + "         exit        " + ConsoleColors.BLUE + "■" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "■■■■■■■■■■■■■■■■■■■■■■■" + ConsoleColors.RESET);
            System.out.print("➤ ");

        }



}
