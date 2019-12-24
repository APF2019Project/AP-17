package control;

import model.Account;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public abstract class Menu {
    public static Menu currentMenu = LoginMenu.loginMenu;
    private Menu parentMenu;
    public Account account;

    protected abstract void exit();

    protected abstract void enterMenu(String menu);

    protected abstract boolean allowsCommand(String command);

    protected abstract void help();

    protected abstract void showMenu();

    public abstract void handleCommand(String command, Scanner scanner) throws IOException;
}
