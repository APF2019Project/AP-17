package control;

import model.Account;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public abstract class Menu {
    public static Menu currentMenu = LoginMenu.loginMenu;
    public final Menu parentMenu;
    public Account account;

    protected abstract boolean allowsCommand(String command);

    public abstract void handleCommand(String command, Scanner scanner) throws IOException;

    protected Menu(Menu parentMenu){
        this.parentMenu = parentMenu;
    }
}
