package control.GameModes;

import control.BattleClasses.Map;
import control.Menu;
import model.Player;

import java.io.IOException;
import java.util.Scanner;

public class Day extends GameModes{

    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {

    }

    @Override
    public void generateMap() {

    }

    @Override
    public void checkState() {

    }

    @Override
    public void handleWin() {

    }

    @Override
    public void getHand() {

    }

    @Override
    protected boolean allowsCommand(String command) {
        return false;
    }

    public Day(Player planter, Player zombieLeader, Map map){
        super(planter, zombieLeader, map);
    }
}
