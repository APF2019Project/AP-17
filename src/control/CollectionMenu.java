package control;

import java.io.IOException;
import java.util.Scanner;

public class CollectionMenu extends Menu {
    public static CollectionMenu collectionMenu = new CollectionMenu();
    public static Menu menu;

    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (command.equals("play")){
            currentMenu = menu;
        } else if (command.equals("show hand")){

        }
    }

    @Override
    protected void exit() {

    }

    @Override
    protected void enterMenu(String menu) {

    }

    @Override
    protected boolean allowsCommand(String command) {
        return false;
    }

    @Override
    protected void help() {

    }

    @Override
    protected void showMenu() {

    }

}
