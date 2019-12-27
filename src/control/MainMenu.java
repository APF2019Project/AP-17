package control;

import view.MenuViews;

import java.util.Scanner;

public class MainMenu extends Menu {
    public static MainMenu mainMenu = new MainMenu();

    public void handleCommand(String command, Scanner scanner) {
        if (allowsCommand(command)) {
            if (command.equals("profile")) {
                currentMenu = ProfileMenu.profileMenu;
                currentMenu.account = currentMenu.parentMenu.account;
            } else if (command.equals("play")) {
                currentMenu = PlayMenu.playMenu;
                currentMenu.account = currentMenu.parentMenu.account;
            }else if (command.equals("shop")){
                currentMenu = Shop.shop;
                currentMenu.account = currentMenu.parentMenu.account;
            }
            else if (command.equals("help")) {
                MenuViews.mainMenuHelp();
            } else if (command.equals("exit")){
                currentMenu = LoginMenu.loginMenu;
            }
        } else {
            MenuViews.mainMenuAllowsCommandError();
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
