package control;

import model.Account;
import model.Card;
import model.Plant;
import model.Zombie;
import view.AccountViews;
import view.CardView;
import view.MenuViews;
import view.PlantViews;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop extends Menu {
    public static Shop shop = new Shop();
    private static ArrayList<Zombie> zombies = new ArrayList<>();
    private static ArrayList<Plant> plants = new ArrayList<>();

    public void handleCommand(String command, Scanner scanner) {
        if (allowsCommand(command)) {
            if (command.equals("show shop")) {
                MenuViews.plants();
                for (int i = 0; i < plants.size(); i++) {
                    Plant plant = plants.get(i);
                    if (account.getCollection().getPlantByName(plant.getName()) == null) {
                        CardView.showNameAndPrice(plant);
                    }
                }
                MenuViews.zombies();
                for (int i = 0; i < zombies.size(); i++) {
                    Zombie zombie = zombies.get(i);
                    if (account.getCollection().getZombieByName(zombie.getName()) == null) {
                        CardView.showNameAndPrice(zombie);
                    }
                }
            } else if (command.equals("show collection")) {
                MenuViews.plants();
                for (int i = 0; i < account.getCollection().getPlants().size(); i++) {
                    Plant plant = account.getCollection().getPlants().get(i);
                    CardView.showNameAndPrice(plant);
                }
                MenuViews.zombies();
                for (int i = 0; i < account.getCollection().getZombies().size(); i++) {
                    Zombie zombie = account.getCollection().getZombies().get(i);
                    CardView.showNameAndPrice(zombie);
                }
            } else if (command.matches("buy \\d+")) {
                String[] commandSplit = command.split(" ");
                String name = commandSplit[1];
                Plant plant = getPlantByName(name);
                Zombie zombie = getZombieByName(name);
                if (plant == null && zombie == null) {
                    MenuViews.cardDoenstExistsError();
                    return;
                }
                if (plant != null) {
                    if (account.getShopCoins() < plant.getPrice()) {
                        MenuViews.notEnoughMoneyError();
                        return;
                    } else {
                        account.getCollection().getPlants().add((Plant) plant.clone());
                    }
                }
                if (zombie != null) {
                    if (account.getShopCoins() < zombie.getPrice()) {
                        MenuViews.notEnoughMoneyError();
                        return;
                    } else {
                        account.getCollection().getZombies().add(zombie.clone());
                    }
                }
            } else if (command.equals("money")) {
                AccountViews.showMoney(account);
            } else if (command.equals("help")){
                MenuViews.shopMenuHelp();
            } else if (command.equals("exit")){
                currentMenu = currentMenu.parentMenu;
            }
        } else {
            MenuViews.shopMenuAllowsCommandError();
        }
    }

    public boolean allowsCommand(String command) {
        return true;
    }

    public void showMenu() {

    }

    public void help() {

    }

    public static ArrayList<Zombie> getZombies() {
        return zombies;
    }

    private Zombie getZombieByName(String name) {
        for (int i = 0; i < zombies.size(); i++) {
            Zombie zombie = zombies.get(i);
            if (zombie.getName().equals(name)) {
                return zombie;
            }
        }
        return null;
    }

    private Plant getPlantByName(String name) {
        for (int i = 0; i < plants.size(); i++) {
            Plant plant = plants.get(i);
            if (plant.getName().equals(name)) {
                return plant;
            }
        }
        return null;
    }

    private Shop() {
        super(MainMenu.mainMenu);
    }

    public void preProcess() {
//
    }
}
