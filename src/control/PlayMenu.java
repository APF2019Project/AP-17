package control;

import control.BattleClasses.Map;
import control.GameModes.Day;
import model.AI;
import model.PlayerTypes.DayAndWaterPlayer;

import java.io.IOException;
import java.util.Scanner;

public class PlayMenu extends Menu {
    public static PlayMenu playMenu = new PlayMenu();
    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (command.equals("day")){
            currentMenu = PlantsCollectionMenu.plantsCollectionMenu;
            DayAndWaterPlayer dayAndWaterPlayer = new DayAndWaterPlayer(this.account, 2);
            this.account.setPlayer(dayAndWaterPlayer);
            AI ai = new AI(null);
            PlantsCollectionMenu.plantsCollectionMenu.menu = new Day(dayAndWaterPlayer
            , ai, new Map("day"));
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
