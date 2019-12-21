package control;

import com.google.gson.Gson;
import model.Account;
import view.LoginMenuViews;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public final class LoginMenu extends Menu {
    public static LoginMenu loginMenu = new LoginMenu();

    public void handleCommand(String command, Menu currentMenu, Scanner scanner) throws FileNotFoundException {
        if (allowsCommand(command)) {
            if (command.equals("create account")) {
                LoginMenuViews.askForUsername();
                String username = scanner.nextLine();
                ArrayList<Account> accounts = Account.getAccounts();
                for (Account account :
                        accounts) {
                    if (account.getUsername().equals(username)) {
                        LoginMenuViews.accountExistsError();
                        return;
                    }
                }
                LoginMenuViews.askForPassword();
                String password = scanner.nextLine();
                Account newAccount = new Account(username, password);
//            newAccount.addToJson();
                Account.saveAccount();
            } else if (command.equals("login")){
                LoginMenuViews.askForUsername();
                String username = LoginMenuViews.scanUsername(scanner) ;
                Account account = Account.getAccountByUsername(username);
                if (account == null){
                    LoginMenuViews.userNotFoundError();
                    return;
                }
                LoginMenuViews.askForPassword();
                String password = LoginMenuViews.scanPassword(scanner) ;
                if (!account.passwordMatches(password)){
                    LoginMenuViews.wrongPasswordError();
                    return;
                }
                currentMenu = MainMenu.mainMenu;
                currentMenu.account = account;
            }
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
