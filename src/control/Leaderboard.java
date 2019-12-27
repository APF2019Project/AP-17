package control;

import model.Account;
import view.AccountViews;
import view.MenuViews;

import java.io.IOException;
import java.util.Scanner;

public final class Leaderboard extends Menu {
    public static Leaderboard leaderboard = new Leaderboard();

    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (allowsCommand(command)) {
            if (command.equals("show")) {
                AccountViews.showLeaderBoard();
            } else if (command.equals("help")) {
                MenuViews.leaderboardHelp();
            } else if (command.equals("exit")) {
                currentMenu = this.parentMenu;
            }
        } else {
            MenuViews.leaderboardAllowsCommandError();
        }
    }

    protected boolean allowsCommand(String command) {
        if (command.equals("show") || command.equals("help")
        || command.equals("exit")){
            return true;
        }
        return false;
    }

    public void exit() {

    }

    public static Leaderboard getLeaderboard() {
        return leaderboard;
    }

    private Leaderboard(){
        super(LoginMenu.loginMenu);
    }
}
