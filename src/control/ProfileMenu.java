package control;

import model.Account;
import view.AccountViews;
import view.MenuViews;

import java.io.IOException;
import java.util.Scanner;

public class ProfileMenu extends Menu {
    public static ProfileMenu profileMenu = new ProfileMenu();

    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (allowsCommand(command)) {
            if (command == "change") {
                Account currentAccount = Account.login(scanner);
                if (currentAccount != null) {
                    this.account = currentAccount;
                }
            } else if (command.equals("delete")) {
                Account.deleteAccount(scanner);
            } else if (command.equals("rename")) {
                AccountViews.askForUsername();
                String username = AccountViews.scanUsername(scanner);
                this.account.setUsername(username);
            } else if (command.equals("create")) {
                Account.createUser(scanner);
            } else if (command.equals("show")) {
                AccountViews.showUsername(this.account);
            } else if (command.equals("help")) {
                MenuViews.profileMenuHelp();
            } else if (command.equals("exit")){
                currentMenu = this.parentMenu;
            }
        } else {
            MenuViews.profileMenuAllowsCommandError();
        }
    }

    protected boolean allowsCommand(String command) {
        return true;
    }

    private ProfileMenu() {
        super(MainMenu.mainMenu);
    }
}
