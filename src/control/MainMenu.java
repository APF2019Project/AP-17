package control;

import java.util.Scanner;

public class MainMenu extends Menu {
    public static MainMenu mainMenu = new MainMenu();

    public void handleCommand(String command, Scanner scanner) {
        if (allowsCommand(command)) {
            if (command.equals("profile")) {
                currentMenu = ProfileMenu.profileMenu;
            }
            else if (command.equals("help")) {
                help();
            }
        }
    }

    public void exit() {
    }

    public void enterMenu(String string) {

    }

    public boolean allowsCommand(String string) {
        return true;
    }

    public void help() {
        System.out.println("main menu");
    }

    public void showMenu() {
        System.out.println("");
    }

    private MainMenu() {

    }
}
