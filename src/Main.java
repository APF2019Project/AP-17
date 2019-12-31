import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.com.google.gson.Gson;
import control.Accessories.*;
import control.Action.*;
import control.LoginMenu;
import control.Menu;
import model.Plant;
import model.Projectile;
import model.Zombie;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true){
            command = scanner.nextLine();
            command = command.toLowerCase();
            if (Menu.currentMenu == null){
                break;
            } else {
                Menu.currentMenu.handleCommand(command, scanner);
            }
        }
    }
}