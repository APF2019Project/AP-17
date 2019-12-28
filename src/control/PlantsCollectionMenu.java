package control;

import control.GameModes.Day;
import model.*;
import view.CardView;
import view.HandViews;
import view.MenuViews;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlantsCollectionMenu extends Menu {
    public static PlantsCollectionMenu plantsCollectionMenu = new PlantsCollectionMenu();
    public Menu menu;

    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (allowsCommand(command)){
            if (command.equals("play")) {
                Day.
                currentMenu = menu;
            } else if (command.equals("show hand")) {
                Hand hand = currentMenu.account.getPlayer().getHand();
                ArrayList<Card> cards = hand.getCards();
                for (Card card :
                        cards) {
                    CardView.showName(card);
                }
            } else if (command.equals("show collection")) {
                Hand hand = currentMenu.account.getPlayer().getHand();
                ArrayList<Plant> plants = currentMenu.account.getCollection().getPlants();
                for (Plant plant :
                        plants) {
                    if (!hand.hasCard(plant)) {
                        CardView.showName(plant);
                    }
                }
            } else if (command.matches("select \\d+")) {
                Collection collection = currentMenu.account.getCollection();
                String[] commandSplit = command.split(" ");
                String name = commandSplit[1];
                Plant plant = collection.getPlantByName(name);
                if (plant == null) {
                    CardView.cardDoesntExistsError();
                    return;
                }
                Hand hand = account.getPlayer().getHand();
                if (hand.hasCard(plant)) {
                    HandViews.hasCardInYourHandError();
                    return;
                }
                Plant newPlant = (Plant) plant.clone();
                ArrayList<Card> cards = hand.getCards();
                cards.add(newPlant);
            } else if (command.matches("remove \\d+")) {
                String[] commandSplit = command.split(" ");
                String name = commandSplit[1];
                Hand hand = account.getPlayer().getHand();
                if (!hand.hasCard(name)) {
                    HandViews.dontHaveCardInYourHandError();
                    return;
                }
                ArrayList<Card> cards = hand.getCards();
                Card card = hand.getCardByName(name);
                cards.remove(card);
            } else if (command.equals("help")){
                MenuViews.collectionMenuHelp();
            }
        } else {
            MenuViews.collectionMenuAllowsCommandError();
        }

    }

    @Override
    protected boolean allowsCommand(String command) {
        if (command.equals("play") || command.equals("show hand")
        || command.equals("show collection") || command.matches("select \\d+")
        || command.matches("remove \\d+") || command.equals("help")
        || command.equals("exit")){
            return true;
        }
        return false;
    }

    private PlantsCollectionMenu() {
        super(PlayMenu.playMenu);
    }
}
