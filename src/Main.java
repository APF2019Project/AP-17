import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.com.google.gson.Gson;
import control.LoginMenu;
import control.Menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true){
            command = scanner.nextLine();
            command = command.toLowerCase();
            if (Menu.currentMenu instanceof LoginMenu && command.equals("exit")){
                break;
            } else {
                Menu.currentMenu.handleCommand(command, scanner);
            }
        }
    }
}