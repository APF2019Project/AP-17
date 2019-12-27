package control;

import java.io.IOException;
import java.util.Scanner;

public final class Leaderboard extends Menu {
    public static Leaderboard leaderboard = new Leaderboard();
    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (allowsCommand(command)){

        }
    }
    protected boolean allowsCommand(String command){
        return true;
    }

    public  void exit(){

    }
}
