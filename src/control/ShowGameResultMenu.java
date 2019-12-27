package control;

import java.io.IOException;
import java.util.Scanner;

public class ShowGameResultMenu extends Menu {
    public static ShowGameResultMenu showGameResultMenu = new ShowGameResultMenu();
    @Override
    protected boolean allowsCommand(String command) {
        return false;
    }

    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {

    }
    private ShowGameResultMenu(){
        super(MainMenu.mainMenu);
    }
}
