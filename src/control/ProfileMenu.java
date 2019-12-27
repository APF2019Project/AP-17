package control;

import model.Account;
import view.AccountViews;

import java.io.IOException;
import java.util.Scanner;

public class ProfileMenu extends Menu {
    public static ProfileMenu profileMenu = new ProfileMenu();

    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (allowsCommand(command)) {
            if (command == "Change") {
                Account currentAccount = Account.login(scanner);
                if (currentAccount != null){
                    this.account = currentAccount;
                }
            }else if (command.equals("Delete")) {
                Account.deleteAccount(scanner);
            }else if (command.equals("Rename")) {
                AccountViews.askForUsername();
                String username = AccountViews.scanUsername(scanner) ;
                this.account.setUsername(username);
            }else if (command.equals("Create")) {
                Account.createUser(scanner);
            }else if (command.equals("show")) {
                AccountViews.showUsername(this.account);
            } else if (command.equals("help")){
                System.out.println("profile menu");
            }
        }
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

    private ProfileMenu() {
        super(MainMenu.mainMenu);
    }
}
