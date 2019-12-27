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
            } else if (command.equals("help")) {
                MenuViews.loginMenuHelp();
            } else if (command.equals("leaderboard")) {
                AccountViews.showLeaderBoard();
            }
        } else {
            MenuViews.loginMenuAllowsCommandError();
        }
    }

    public void login(String usrname, String password) {

    }

    public void getLeaderboard() {

    }

    protected void exit() {

    }

    protected void enterMenu(String menu) {

    }

    protected boolean allowsCommand(String command) {
        if (command.equals("create account") || command.equals("login")
        || command.equals("leaderboard") || command.equals("help")){
            return true;
        }
        return false;
    }

    protected void help() {

    }

    protected void showMenu() {

    }

    protected boolean checkPassword(String username, String password) {
        return true;
    }

    private LoginMenu() {

    }

}
