package control.GameModes;

import control.BattleClasses.Map;
import control.Menu;
import model.Player;
import view.BattleViews;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public final class Day extends GameModes {
    private int ranodmNumberToIncreaseSuns;
    private int increaseSunNumbers;
    private int nextWave = 3;
    private int randomZombieNumbersForEachWave;

    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (allowsCommand(command)) {
            if (command.equals("show lawn")) {
                BattleViews.showLawn(map);
            }
        }
    }


    @Override
    public void handleWin() {

    }

    @Override
    public void preProcess() {
        increaseSunNumbers = ((int) Math.random()) % 4 + 2;
        ranodmNumberToIncreaseSuns = ((int) Math.random()) % 2;
        randomZombieNumbersForEachWave = ((int) Math.random()) % 7 + 4;
    }


    @Override
    protected boolean allowsCommand(String command) {
        return true;
    }

    public Day(Player planter, Player zombieLeader, Map map) {
        super(planter, zombieLeader, map);
        preProcess();
    }
}
