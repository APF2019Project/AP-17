package control.GameModes;

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
}
