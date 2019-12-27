package control;

import java.util.Scanner;

public class MainMenu extends Menu {
    public static MainMenu mainMenu = new MainMenu();

    public void handleCommand(String command, Scanner scanner) {
        if (allowsCommand(command)) {
            if (command.equals("profile")) {
                currentMenu = ProfileMenu.profileMenu;
            } else if (command.equals("play")) {
                currentMenu = PlayMenu.playMenu;
            }else if (command.equals("shop")){
                currentMenu = Shop.shop;
            }
            else if (command.equals("help")) {
            } else if (command.equals("exit")){

            }
        } else {

        }
    }

    public boolean allowsCommand(String command) {
        if (command.equals("profile") || command.equals("play")
        || command.equals("shop") || command.equals("help")
        || command.equals("exit")){
            return true;
        }
        return false;
    }

    private MainMenu() {
        super(LoginMenu.loginMenu);
    }
}
