import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.com.google.gson.Gson;
import control.LoginMenu;
import control.Menu;
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

//        FileWriter fileWriter = new FileWriter("../model/zombies.json");
        YaGson yaGson = new YaGson();
        ArrayList<Zombie> zombies = new ArrayList<>();
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