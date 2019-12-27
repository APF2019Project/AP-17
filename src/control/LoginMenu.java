package control;

import model.Account;
import view.AccountViews;
import view.MenuViews;

import java.io.IOException;
import java.util.Scanner;

public final class LoginMenu extends Menu {
    public static LoginMenu loginMenu = new LoginMenu();

    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (allowsCommand(command)) {
            if (command.equals("create account")) {
                Account.createUser(scanner);
            } else if (command.equals("login")) {
                Account currentAccount = Account.login(scanner);
                if (currentAccount != null) {
                    currentMenu = MainMenu.mainMenu;
                    currentMenu.account = currentAccount;
                }
            } else if (command.equals("leaderboard")) {
                currentMenu = Leaderboard.leaderboard;
            } else if (command.equals("help")) {
                MenuViews.loginMenuHelp();
            } else if (command.equals("exit")) {
                currentMenu =  this.parentMenu;
            }
        } else {
            MenuViews.loginMenuAllowsCommandError();
        }
    }

    protected boolean allowsCommand(String command) {
        if (command.equals("create account") || command.equals("login")
                || command.equals("leaderboard") || command.equals("help")
                || command.equals("exit")) {
            return true;
        }
        return false;
    }
    private LoginMenu() {
        this.parentMenu = null;
    }

}
