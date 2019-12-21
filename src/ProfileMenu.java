import control.LoginMenu;
import control.Menu;
import model.Account;
import view.LoginMenuViews;

import java.util.Scanner;

public class ProfileMenu extends Menu {
    public static ProfileMenu profileMenu = new ProfileMenu();

    public void handleCommand(String command , Menu CurrentMenu , Scanner scanner) {
        if (allowsCommand(command)) {
            if (command == "Change") {
                LoginMenuViews.askForUsername();
                String username = LoginMenuViews.scanUsername(scanner);
                Account account = Account.getAccountByUsername(username);
                if (account == null){
                    LoginMenuViews.userNotFoundError();
                    return;
                }
                this.account = account ;
            }else if (command == "Delete") {
                LoginMenuViews.askForUsername();
                String username = LoginMenuViews.scanUsername(scanner) ;
                LoginMenuViews.askForPassword();
                String password = LoginMenuViews.scanUsername(scanner) ;
                if (Account.)




            }else if (command == "Rename") {
                LoginMenuViews.askForUsername();
                String username = LoginMenuViews.scanUsername(scanner) ;
                this.account.setUsername(username);
            }else if (command == "Create") {
                Account.createUser(scanner);
            }else if (command == "Show") {
                ProfileMenuViews.show(this.account);
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

    }
}
