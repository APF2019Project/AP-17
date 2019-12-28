package control.GameModes;

import control.BattleClasses.Map;
import model.Player;

import java.io.IOException;
import java.util.Scanner;

public class Zombie extends GameModes {


    @Override
    protected boolean allowsCommand(String command) {
        return false;
    }

    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {

    }
    public Zombie(Player planter, Player zombieLeader, Map map){
        super(planter, zombieLeader, map);
    }
}
