import control.LoginMenu;
import control.Menu;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String command;
        LoginMenu loginMenu = LoginMenu.loginMenu;
        Menu menu = loginMenu;
        while (true){
            command = scanner.nextLine();
            command = command.toLowerCase();
            if (menu instanceof LoginMenu && command.equals("exit")){
                break;
            } else {
                menu.handleCommand(command, menu, scanner);
            }
        }
    }
}
