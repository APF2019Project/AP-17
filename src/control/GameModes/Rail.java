package control.GameModes;

import control.BattleClasses.Map;
import control.Menu;
import model.Player;

import java.io.IOException;
import java.util.Scanner;

public class Rail extends GameModes {


    @Override
    protected boolean allowsCommand(String command) {
        return false;
    }

    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {

    }
    public Rail(Player planter, Player zombieLeader, Map map){
        super(planter, zombieLeader, map);
    }
}
