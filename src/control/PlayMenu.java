package control;

import control.GameModes.Day;

import java.io.IOException;
import java.util.Scanner;

public class PlayMenu extends Menu {
    public static PlayMenu playMenu = new PlayMenu();
    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (command.equals("day")){
            currentMenu = PlantsCollectionMenu.plantsCollectionMenu;
            PlantsCollectionMenu.plantsCollectionMenu.menu = Day.day;
            currentMenu.account = currentMenu.parentMenu.account;
            currentMenu.account.createDayAndWaterPlayer();
        }
    }


    protected boolean allowsCommand(String command) {
        return true;
    }

    private PlayMenu(){
        super(MainMenu.mainMenu);
    }


}
