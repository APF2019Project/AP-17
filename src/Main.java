import control.LoginMenu;
import control.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

            }
        }
    }
}
