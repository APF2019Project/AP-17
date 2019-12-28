package model;

import control.Accessories.Car;
import control.BattleClasses.Cell;
import control.BattleClasses.Map;

import java.util.ArrayList;

public abstract class Card {
    private static ArrayList<Card> cards = new ArrayList<>();
    private final String name;
    private Cell location;
    private final int price;
    private final int maxHealth;
    private int health;
    private Map map;

    public Card(String name, int maxHealth, int price) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.price = price;
    }



    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    private boolean hasCardInFront(){
        int x = location.getX();
        Cell[] row = map.getCells()[x];
        int y = location.getY();
        for (int i = y; i < row.length; i++) {
            if (row[i].getZombies().size() != 0){
                return true;
            }
        }
        return false;
    }
}
