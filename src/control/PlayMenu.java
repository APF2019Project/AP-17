package control;

import control.GameModes.Day;
import model.Player;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class PlayMenu extends Menu {
    public static PlayMenu playMenu = new PlayMenu();
    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (command.equals("day")){
            currentMenu = CollectionMenu.collectionMenu;
            CollectionMenu.menu = Day.day;
        }
    }


    protected boolean allowsCommand(String command) {
        return true;
    }

    private PlayMenu(){
        super(MainMenu.mainMenu);
    }


}
