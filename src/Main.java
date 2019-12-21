import control.LoginMenu;
import control.Menu;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String command;
        Menu currentMenu = Menu.currentMenu;
        while (true){
            command = scanner.nextLine();
            command = command.toLowerCase();
            if (currentMenu instanceof LoginMenu && command.equals("exit")){
                break;
            } else {
                currentMenu.handleCommand(command, currentMenu, scanner);
            }
        }
    }
}