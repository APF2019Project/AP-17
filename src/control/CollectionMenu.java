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
    protected boolean allowsCommand(String command) {
        return false;
    }

    private CollectionMenu(){
        super(PlayMenu.playMenu);
    }
}
