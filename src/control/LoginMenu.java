package control;

import model.Account;
import view.LoginMenuViews;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public final class LoginMenu extends Menu {
    public static LoginMenu loginMenu = new LoginMenu();

    protected void handleCommand(String command, Menu menu, Scanner scanner) {
        if (command.equals("create account")) {
            String username = scanner.nextLine();
            ArrayList<Account> accounts = Account.getAccounts();
            for (Account account :
                    accounts) {
                if (account.getUsername().equals(username)){
                    LoginMenuViews.accountExistsError();
                    return;
                }
            }
            String password = scanner.nextLine();
            new Account(username, password);

        }
    }

    public void createAccount(String username, String passwo) {

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
