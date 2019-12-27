package control;

import model.Account;
import view.AccountViews;
import view.LoginMenuViews;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public final class LoginMenu extends Menu {
    public static LoginMenu loginMenu = new LoginMenu();

    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (allowsCommand(command)) {
            if (command.equals("create account")) {
                Account.createUser(scanner);
            } else if (command.equals("login")){
                Account currentAccount = Account.login(scanner);
                if (currentAccount != null){
                    currentMenu = MainMenu.mainMenu;
                    currentMenu.account = currentAccount;
                }
            } else if (command.equals("help")){
                System.out.println("login menu");
            } else if (command.equals("leaderboard")){
                AccountViews.showLeaderBoard();
            }
        } else {

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
        return true;
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
