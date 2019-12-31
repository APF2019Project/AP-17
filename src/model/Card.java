package model;

import control.Accessories.Car;
import control.BattleClasses.Cell;
import control.BattleClasses.Map;

import java.util.ArrayList;

public abstract class Card {
    protected static ArrayList<Card> cards = new ArrayList<>();
    protected final String name;
    protected Cell location;
    protected final int price;
    protected final int maxHealth;
    protected int health;
    protected Map map;
    protected boolean water;

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

    public Cell getLocation() {
        return location;
    }

    public Map getMap() {
        return map;
    }

    public boolean isWater() {
        return water;
    }
}
